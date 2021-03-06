/*
 * Copyright (c) 2012, 2013 Hemanta Sapkota.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Hemanta Sapkota (laex.pearl@gmail.com)
 */
package com.laex.cg2d.render;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.laex.cg2d.model.ScreenModel.CGScreenModel;

/**
 * The Class MyGdxGameDesktop.
 * 
 * @author hemantasapkota
 */
public class MyGdxGameDesktop {

  /** The lapp. */
  private static LwjglApplication lapp;

  /**
   * Construct.
   * 
   * @return the options
   */
  public static Options construct() {
    final Options gnuOptions = new Options();

    Option cardWidth = new Option("cw", true, "Card Width");
    Option cardHeight = new Option("ch", true, "Card Height");
    Option cardNoX = new Option("cx", true, "Card No X");
    Option cardNoY = new Option("cy", true, "Card No Y");

    Option drawBodies = new Option("body", "Draw Bodies");
    Option drawJoint = new Option("joint", "Draw Joints");
    Option drawAABB = new Option("aabb", "Draw AABB");
    Option drawInactiveBodies = new Option("inactive", "Draw Inactive Bodieds");
    Option drawDebugData = new Option("debugData", "Draw Debug Data");
    Option drawEntities = new Option("entities", "Draw Entities");
    Option mouseJoint = new Option("mouseJoint", "Install Mouse Joint");

    Option ptmRatio = new Option("ptmRatio", true, "PIXELS TO METERS (PTM) Ratio");
    Option gravityX = new Option("gravityX", true, "Gravity X. Can be negative.");
    Option gravityY = new Option("gravityY", true, "Gravity Y. Can be negative.");
    Option timestep = new Option("timeStep", true, "TimeStep");
    Option velocityItr = new Option("velItr", true, "Velocity Iterations");
    Option positionItr = new Option("posItr", true, "Position Iterations");

    Option screenFile = new Option("screenFile", true, "Screen File");
    Option screenController = new Option("screenController", true, "Screen Controller File");

    gnuOptions.addOption(cardWidth);
    gnuOptions.addOption(cardHeight);
    gnuOptions.addOption(cardNoX);
    gnuOptions.addOption(cardNoY);
    gnuOptions.addOption(drawBodies);
    gnuOptions.addOption(drawJoint);
    gnuOptions.addOption(drawAABB);
    gnuOptions.addOption(drawInactiveBodies);
    gnuOptions.addOption(drawDebugData);
    gnuOptions.addOption(drawEntities);
    gnuOptions.addOption(mouseJoint);

    gnuOptions.addOption(ptmRatio);
    gnuOptions.addOption(gravityX);
    gnuOptions.addOption(gravityY);
    gnuOptions.addOption(timestep);
    gnuOptions.addOption(velocityItr);
    gnuOptions.addOption(positionItr);

    gnuOptions.addOption(screenFile);
    gnuOptions.addOption(screenController);

    return gnuOptions;
  }

  /**
   * Parses the.
   * 
   * @param options
   *          the options
   * @param args
   *          the args
   * @return the map
   * @throws ParseException
   *           the parse exception
   */
  private static Map<String, Object> parse(Options options, String args[]) throws ParseException {
    Map<String, Object> prefs = new HashMap<String, Object>();

    CommandLineParser parse = new GnuParser();
    CommandLine cmd = parse.parse(options, args);

    // CG2D File
    if (cmd.hasOption("screenFile")) {
      prefs.put(PreferenceConstants.SCREEN_FILE, cmd.getOptionValue("screenFile"));
    }

    // screen controller file
    if (cmd.hasOption("screenController")) {
      prefs.put(PreferenceConstants.SCREEN_CONTROLLER, cmd.getOptionValue("screenController"));
    }

    return prefs;
  }

  /**
   * The main method.
   * 
   * @param args
   *          the arguments
   * @throws ParseException
   *           the parse exception
   */
  public static void main(String[] args) throws ParseException {
    Options options = construct();

    Map<String, Object> prefs = parse(options, args);
    String screenFile = (String) prefs.get(PreferenceConstants.SCREEN_FILE);
    String screenControllerFile = (String) prefs.get(PreferenceConstants.SCREEN_CONTROLLER);

    InputStream is;
    CGScreenModel model = null;

    try {
      is = new FileInputStream(screenFile);
      model = CGScreenModel.parseFrom(is);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    int cardWidth = model.getScreenPrefs().getCardPrefs().getCardWidth();
    int cardHeight = model.getScreenPrefs().getCardPrefs().getCardHeight();

    LwjglApplicationConfiguration lwapp = new LwjglApplicationConfiguration();
    lwapp.width = cardWidth;
    lwapp.height = cardHeight;
    // lwapp.title = screenFile;
    lwapp.forceExit = false;

    final CGScreenModel modelMain = model;
    MyGdxGame mgd = new MyGdxGame(screenControllerFile) {
      @Override
      public CGScreenModel loadGameModel() {
        return modelMain;
      }
    };

    // new JoglApplication(mgd, jac);
    lapp = new LwjglApplication(mgd, lwapp);
  }

  /**
   * Exit.
   */
  public static void exit() {
    lapp.error("", "Exiting because of some error");
    lapp.exit();
    System.exit(0);
  }

  /**
   * Lwjgl app.
   * 
   * @return the lwjgl application
   */
  public static LwjglApplication lwjglApp() {
    return lapp;
  }
}
