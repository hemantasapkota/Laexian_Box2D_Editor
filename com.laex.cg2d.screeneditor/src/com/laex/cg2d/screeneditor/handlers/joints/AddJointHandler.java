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
package com.laex.cg2d.screeneditor.handlers.joints;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.badlogic.gdx.physics.box2d.JointDef.JointType;
import com.laex.cg2d.model.model.Shape;
import com.laex.cg2d.screeneditor.Activator;
import com.laex.cg2d.screeneditor.commands.JointCreateCommand;
import com.laex.cg2d.screeneditor.editparts.ShapeEditPart;

/**
 * The Class AddJointHandler.
 */
public class AddJointHandler extends AbstractHandler {

  /**
   * Gets the joint type.
   *
   * @param c the c
   * @return the joint type
   */
  private JointType getJointType(Command c) {
    String n = "";
    try {
      n = c.getName();
    } catch (NotDefinedException e) {
      Activator.log(e);
    }

    if (n.equals("Distance"))
      return JointType.DistanceJoint;
    else if (n.equals("Revolute"))
      return JointType.RevoluteJoint;
    else if (n.equals("Prismatic"))
      return JointType.PrismaticJoint;
    else if (n.equals("Weld"))
      return JointType.WeldJoint;
    else if (n.equals("Friction"))
      return JointType.FrictionJoint;
    else if (n.equals("Pulley"))
      return JointType.PulleyJoint;

    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    IEditorPart ep = (IEditorPart) HandlerUtil.getActiveEditor(event);
    GraphicalViewer gv = (GraphicalViewer) ep.getAdapter(GraphicalViewer.class);

    int i = 0;

    CompoundCommand cc = new CompoundCommand();

    while (i < gv.getSelectedEditParts().size()) {
      int targetIndex = i + 1;

      ShapeEditPart sourceEditPart = (ShapeEditPart) gv.getSelectedEditParts().get(i);

      boolean isNextTargetValid = targetIndex < gv.getSelectedEditParts().size();

      if (!isNextTargetValid) {
        i++;
        continue;
      }

      ShapeEditPart targetEditPart = (ShapeEditPart) gv.getSelectedEditParts().get(targetIndex);

      Shape source = (Shape) sourceEditPart.getModel();
      Shape target = (Shape) targetEditPart.getModel();

      JointType jt = getJointType(event.getCommand());

      JointCreateCommand jcc = new JointCreateCommand(source, jt);
      jcc.setTarget(target);

      cc.add(jcc);

      i++;

    }

    gv.getEditDomain().getCommandStack().execute(cc);

    return null;
  }

}