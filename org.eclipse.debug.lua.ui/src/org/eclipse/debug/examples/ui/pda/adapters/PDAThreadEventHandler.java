/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.examples.ui.pda.adapters;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.examples.core.pda.model.PDAThread;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;
import org.eclipse.debug.internal.ui.viewers.provisional.AbstractModelProxy;
import org.eclipse.debug.internal.ui.viewers.update.DebugEventHandler;


/**
 * @since 3.2
 */
public class PDAThreadEventHandler extends DebugEventHandler {
	
	private IStackFrame fPrev = null;
	
	/**
	 * Constructs and event handler for a threads in the given viewer.
	 * 
	 * @param viewer
	 */
	public PDAThreadEventHandler(AbstractModelProxy proxy) {
		super(proxy);
	}

	protected void handleSuspend(DebugEvent event) {
        IThread thread = (IThread) event.getSource();
        int extras = IModelDelta.STATE;
        if (event.getDetail() == DebugEvent.BREAKPOINT | event.getDetail() == DebugEvent.CLIENT_REQUEST) {
            extras = IModelDelta.EXPAND;
        }
    	fireDeltaUpdatingTopFrame(thread, IModelDelta.NO_CHANGE | extras);
	}
	
	private boolean isEqual(Object o1, Object o2) {
		if (o1 == o2) {
			return true;
		}
		if (o1 == null) {
			return false;
		}
		return o1.equals(o2);
	}

	protected void handleResume(DebugEvent event) {
		IThread thread = (IThread) event.getSource();
		fireDeltaAndClearTopFrame(thread, IModelDelta.STATE | IModelDelta.CONTENT);
	}

	protected void handleCreate(DebugEvent event) {
		fireDeltaAndClearTopFrame((IThread) event.getSource(), IModelDelta.ADDED);
	}

	protected void handleTerminate(DebugEvent event) {
		fireDeltaAndClearTopFrame((IThread) event.getSource(), IModelDelta.REMOVED);
	}

	protected void handleChange(DebugEvent event) {
		fireDeltaUpdatingTopFrame((IThread) event.getSource(), IModelDelta.STATE);
	}

	protected void handleLateSuspend(DebugEvent suspend, DebugEvent resume) {
		IThread thread = (IThread) suspend.getSource();
		fireDeltaUpdatingTopFrame(thread, IModelDelta.CONTENT | IModelDelta.EXPAND);
	}

	protected void handleSuspendTimeout(DebugEvent event) {
		IThread thread = (IThread) event.getSource();
		fireDeltaAndClearTopFrame(thread, IModelDelta.CONTENT);
	}
	
	private ModelDelta buildRootDelta() {
		return new ModelDelta(getLaunchManager(), IModelDelta.NO_CHANGE);
	}

	private ILaunchManager getLaunchManager() {
		return DebugPlugin.getDefault().getLaunchManager();
	}
	
	protected ModelDelta addTarget(ModelDelta delta, IThread thread) {
		ILaunch launch = thread.getLaunch();
		Object[] children = launch.getChildren();
		delta = delta.addNode(launch, indexOf(getLaunchManager().getLaunches(), launch), IModelDelta.NO_CHANGE, children.length);
		IDebugTarget debugTarget = thread.getDebugTarget();
		int numFrames = -1;
		try {
			numFrames = thread.getStackFrames().length;
		} catch (DebugException e) {
		}
		return delta.addNode(debugTarget, indexOf(children, debugTarget), IModelDelta.NO_CHANGE, numFrames);
	}

	private void fireDeltaAndClearTopFrame(IThread thread, int flags) {
		ModelDelta delta = buildRootDelta();
		addTarget(delta, thread);
		synchronized (this) {
			fPrev = null;
		}
		fireDelta(delta);
	}
	
	private void fireDeltaUpdatingTopFrame(IThread thread, int flags) {
		ModelDelta delta = buildRootDelta();
		ModelDelta node = addTarget(delta, thread);
		synchronized (this) {
	    	IStackFrame prev = fPrev;
	    	IStackFrame frame = null;
			try {
				 frame = thread.getTopStackFrame();
			} catch (DebugException e) {
			}
	    	if (isEqual(frame, prev)) {
	    		node.setFlags(flags);
	    	} else {
				node.setFlags(flags | IModelDelta.CONTENT);
	    	}
	    	if (frame != null) {
	            node.addNode(frame, 0, IModelDelta.STATE | IModelDelta.SELECT, 0);
	        }
	    	fPrev = frame;
		}
    	fireDelta(delta);
	}	
	
	protected boolean handlesEvent(DebugEvent event) {
		return event.getSource() instanceof PDAThread;
	}

}
