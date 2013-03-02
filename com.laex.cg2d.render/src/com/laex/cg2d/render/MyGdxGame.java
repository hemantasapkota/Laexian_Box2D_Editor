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

import java.lang.reflect.Field;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.laex.cg2d.protobuf.GameObject.CGGameModel;

/**
 * The Class MyGdxGame.
 */
public abstract class MyGdxGame extends ApplicationAdapter {

  /** The batch. */
  private SpriteBatch batch;

  /** The cam. */
  private OrthographicCamera cam;

  /** The model. */
  private CGGameModel model;

  /** The world. */
  private World world;

  /** The state time. */
  float stateTime;

  /** The shape manager. */
  private ShapeManager shapeManager;

  /** The bg manager. */
  private BackgroundManager bgManager;

  /** The entity manager. */
  private EntityManager entityManager;

  /** The mouse joint manager. */
  private MouseJointManager mouseJointManager;

  /** The gravity x. */
  private float gravityX;

  /** The gravity y. */
  private float gravityY;

  /** The time step. */
  private float timeStep;

  /** The velocity iterations. */
  private int velocityIterations;

  /** The position iterations. */
  private int positionIterations;

  /** The lua script manager. */
  private LuaScriptManager luaScriptManager;

  /** The screen controller file lua. */
  private String screenControllerFileLua;

  /** The gdx input keys. */
  private static Field[] gdxInputKeys = Input.Keys.class.getFields();

  /**
   * Instantiates a new my gdx game.
   *
   * @param screenControllerFile the screen controller file
   */
  public MyGdxGame(String screenControllerFile) {
    this.screenControllerFileLua = screenControllerFile;
  }

  /**
   * Load game model.
   * 
   * @return the cG game model
   * @throws GdxRuntimeException
   *           the gdx runtime exception
   */
  public abstract CGGameModel loadGameModel() throws GdxRuntimeException;

  /*
   * (non-Javadoc)
   * 
   * @see com.badlogic.gdx.ApplicationAdapter#create()
   */
  @Override
  public void create() {
    model = loadGameModel();

    gravityX = model.getScreenPrefs().getWorldPrefs().getGravityX();
    gravityY = model.getScreenPrefs().getWorldPrefs().getGravityY();
    timeStep = model.getScreenPrefs().getWorldPrefs().getTimeStep();
    velocityIterations = model.getScreenPrefs().getWorldPrefs().getVelocityIterations();
    positionIterations = model.getScreenPrefs().getWorldPrefs().getPositionIterations();

    Texture.setEnforcePotImages(false);

    // models init
    world = new World(new Vector2(gravityX, gravityY), true);

    // render init
    batch = new SpriteBatch();
    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();

    cam = new OrthographicCamera(w / IGameComponentManager.MAGIC_SCALAR, h / IGameComponentManager.MAGIC_SCALAR);
    cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);

    shapeManager = new ShapeManager(model, world, cam);
    entityManager = new EntityManager(model, world, cam, batch);
    bgManager = new BackgroundManager(model, world, cam, batch);
    mouseJointManager = new MouseJointManager(model, world, cam);
    luaScriptManager = new LuaScriptManager(model, world, cam, screenControllerFileLua);

    mouseJointManager.create();
    shapeManager.create();
    bgManager.create();
    entityManager.create();
    luaScriptManager.create();

    Gdx.input.setInputProcessor(mouseJointManager);
  }

  /**
   * Handle input.
   *
   */
  private void handleInput() {
    //is it possible to excute the script, if not, then dont even bother to handle input
    if (!luaScriptManager.canExecute()) {
      return;
    }

    //go through all the fields defined in gdx input keys
    //check if any of them is pressed. if pressed, exceute the script and forward the key name with it
    for (Field f : MyGdxGame.gdxInputKeys) {

      try {
        
        if (Gdx.input.isKeyPressed(f.getInt(f))) {
          luaScriptManager.executeKeyPressed(f.getName());
        }

      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }

    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.badlogic.gdx.ApplicationAdapter#dispose()
   */
  @Override
  public void dispose() {
    mouseJointManager.dispose();
    bgManager.dispose();
    shapeManager.dispose();
    entityManager.dispose();
    luaScriptManager.dispose();
    batch.dispose();
    world.dispose();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.badlogic.gdx.ApplicationAdapter#render()
   */
  @Override
  public void render() {
    handleInput();

    GL10 gl = Gdx.graphics.getGL10();
    stateTime += Gdx.graphics.getDeltaTime();
    entityManager.updateStateTime(stateTime);

    world.step(1 / timeStep, velocityIterations, positionIterations);
    updateCamera(gl);

    batch.setProjectionMatrix(cam.combined);

    bgManager.render();
    entityManager.render();
    shapeManager.render();
    luaScriptManager.render();
  }

  /**
   * Update camera.
   * 
   * @param gl
   *          the gl
   */
  private void updateCamera(GL10 gl) {
    gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

    cam.update();
    cam.apply(gl);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.badlogic.gdx.ApplicationAdapter#resize(int, int)
   */
  @Override
  public void resize(int width, int height) {
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.badlogic.gdx.ApplicationAdapter#pause()
   */
  @Override
  public void pause() {
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.badlogic.gdx.ApplicationAdapter#resume()
   */
  @Override
  public void resume() {
  }
}
