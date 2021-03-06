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
package com.laex.cg2d.screeneditor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;

/**
 * The Class ScreenEditorContextMenuProvider.
 */
class ScreenEditorContextMenuProvider extends ContextMenuProvider {

  /** The action registry. */
  private ActionRegistry actionRegistry;

  /** The edit part viewer. */
  private EditPartViewer editPartViewer;

  /**
   * Instantiates a new screen editor context menu provider.
   * 
   * @param viewer
   *          the viewer
   * @param registry
   *          the registry
   */
  public ScreenEditorContextMenuProvider(EditPartViewer viewer, ActionRegistry registry) {
    super(viewer);
    if (registry == null) {
      throw new IllegalArgumentException();
    }
    actionRegistry = registry;
    this.editPartViewer = viewer;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.
   * action.IMenuManager)
   */
  public void buildContextMenu(IMenuManager menu) {
  }

  /**
   * Gets the action.
   * 
   * @param actionId
   *          the action id
   * @return the action
   */
  private IAction getAction(String actionId) {
    return actionRegistry.getAction(actionId);
  }
}
