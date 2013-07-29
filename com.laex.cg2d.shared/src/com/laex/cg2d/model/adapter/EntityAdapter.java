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
package com.laex.cg2d.model.adapter;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.laex.cg2d.model.ScreenModel.CGEntity;
import com.laex.cg2d.model.ScreenModel.CGEntityAnimation;
import com.laex.cg2d.model.ScreenModel.CGEntityCollisionType;
import com.laex.cg2d.model.ScreenModel.CGEntitySpritesheetItem;
import com.laex.cg2d.model.ScreenModel.CGVector2;
import com.laex.cg2d.model.model.Entity;
import com.laex.cg2d.model.model.EntityAnimation;
import com.laex.cg2d.model.model.EntityCollisionType;
import com.laex.cg2d.model.model.EntitySpritesheetItem;
import com.laex.cg2d.model.util.EntitiesUtil;

/*
 * Bi-directional adapter between Entity & CGEntity
 */
/**
 * The Class EntityAdapter.
 */
public class EntityAdapter {

  /**
   * To cg entity collision type.
   * 
   * @param et
   *          the et
   * @return the cG entity collision type
   */
  public static CGEntityCollisionType toCGEntityCollisionType(EntityCollisionType et) {
    switch (et) {
    case BOX:
      return CGEntityCollisionType.BOX;
    case CIRCLE:
      return CGEntityCollisionType.CIRCLE;
    case CUSTOM:
      return CGEntityCollisionType.CUSTOM;
    case NONE:
      return CGEntityCollisionType.NONE;
    }
    return CGEntityCollisionType.NONE;
  }

  /**
   * To entity collision type.
   * 
   * @param cgt
   *          the cgt
   * @return the entity collision type
   */
  public static EntityCollisionType toEntityCollisionType(CGEntityCollisionType cgt) {
    switch (cgt) {
    case BOX:
      return EntityCollisionType.BOX;
    case CIRCLE:
      return EntityCollisionType.CIRCLE;
    case CUSTOM:
      return EntityCollisionType.CUSTOM;
    case NONE:
      return EntityCollisionType.NONE;
    default:
      break;
    }
    return EntityCollisionType.NONE;
  }

  /**
   * New default entity.
   * 
   * @param filename
   *          the filename
   * @return the entity
   */
  public static Entity newDefaultEntity(String filename) {
    Entity entityModel = new Entity();
    entityModel.setInternalName(EntitiesUtil.getInternalName(filename));

    EntityAnimation ea = new EntityAnimation();
    ea.setAnimationName("Animation 1");
    ea.setDefaultAnimation(true);
    ea.setVertices(new ArrayList<Vector2>());
    ea.setShapeType(EntityCollisionType.NONE);

    entityModel.addEntityAnimation(ea);

    return entityModel;
  }

  /**
   * As cg entity.
   * 
   * @param e
   *          the e
   * @return the cG entity
   */
  public static CGEntity asCGEntity(Entity e) {
    CGEntity.Builder entityBuilder = CGEntity.newBuilder().setInternalName(e.getInternalName());

    for (EntityAnimation ea : e.getAnimationList()) {

      CGEntityAnimation.Builder eaBuilder = CGEntityAnimation.newBuilder()
          .setAnimationDuration(ea.getAnimationDuration()).setAnimationName(ea.getAnimationName())
          .setCollisionType(toCGEntityCollisionType(ea.getShapeType()))
          .setDefaultAnimation(ea.isDefaultAnimation())
          .setFixtureFile(ResourceFileAdapter.asCGResourceFile(ea.getFixtureResourceFile()))
          .setSpritesheetFile(ResourceFileAdapter.asCGResourceFile(ea.getSpritesheetFile()));

      /* Add vertices */
      for (Vector2 v : ea.getVertices()) {
        eaBuilder = eaBuilder.addVertices(Vector2Adapter.asCGVector2(v));
      }

      /* Ad entity spritesheet items */
      eaBuilder.setSpritesheetJsonFile(ResourceFileAdapter.asCGResourceFile(ea.getSpritesheetMapperFile()));
      
      for (EntitySpritesheetItem esi : ea.getSpritesheetItems()) {
        CGEntitySpritesheetItem.Builder cgesiBuilder = CGEntitySpritesheetItem.newBuilder();
        
        CGEntitySpritesheetItem entSpritesheetItem = cgesiBuilder.setFrameIndex(esi.getFrameIndex())
            .setX(esi.getExtractBounds().x).setY(esi.getExtractBounds().y).setW(esi.getExtractBounds().width)
            .setH(esi.getExtractBounds().height).build();
        
        eaBuilder.addSpritesheetItems(entSpritesheetItem);

      }

      CGEntityAnimation cgEa = eaBuilder.build();
      entityBuilder = entityBuilder.addAnimations(cgEa);
    }
    return entityBuilder.build();
  }

  /**
   * As entity.
   * 
   * @param cge
   *          the cge
   * @return the entity
   */
  public static Entity asEntity(CGEntity cge) {
    Entity entityModel = new Entity();
    entityModel.setInternalName(cge.getInternalName());

    for (CGEntityAnimation cgEa : cge.getAnimationsList()) {
      EntityAnimation ea = new EntityAnimation();
      ea.setAnimationDuration(cgEa.getAnimationDuration());
      ea.setAnimationName(cgEa.getAnimationName());
      ea.setDefaultAnimation(cgEa.getDefaultAnimation());
      ea.setFixtureResourceFile(ResourceFileAdapter.asResourceFile(cgEa.getFixtureFile()));
      ea.setSpritesheetFile(ResourceFileAdapter.asResourceFile(cgEa.getSpritesheetFile()));
      ea.setShapeType(toEntityCollisionType(cgEa.getCollisionType()));

      for (CGVector2 cv : cgEa.getVerticesList()) {
        ea.getVertices().add(new Vector2(cv.getX(), cv.getY()));
      }

      ea.setSpritesheetMapperFile(ResourceFileAdapter.asResourceFile(cgEa.getSpritesheetJsonFile()));
      
      for (CGEntitySpritesheetItem cesi : cgEa.getSpritesheetItemsList()) {
        EntitySpritesheetItem esi = new EntitySpritesheetItem();
        esi.setExtractBounds(new Rectangle(cesi.getX(), cesi.getY(), cesi.getW(), cesi.getH()));
        esi.setFrameIndex(cesi.getFrameIndex());
        ea.getSpritesheetItems().add(esi);
      }

      entityModel.addEntityAnimation(ea);
    }
    
    entityModel.setDefaultFrame(EntitiesUtil.getDefaultFrame(entityModel));

    return entityModel;
  }

}
