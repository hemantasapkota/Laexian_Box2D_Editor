/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Bjorn Freeman-Benson - initial API and implementation
 *******************************************************************************/
/******************************************************************************
 * Changes:
 *     Copyright (c) 2008 VeriSign, Inc. All rights reserved.
 *     John Rodriguez
 *     Retarget to Lua, Lua label changes.
******************************************************************************/
package org.eclipse.debug.examples.ui.pda.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.examples.core.pda.DebugCorePlugin;
import org.eclipse.debug.examples.core.pda.breakpoints.PDALineBreakpoint;
import org.eclipse.debug.examples.core.pda.breakpoints.PDAWatchpoint;
import org.eclipse.debug.examples.core.pda.model.PDADebugTarget;
import org.eclipse.debug.examples.core.pda.model.PDAStackFrame;
import org.eclipse.debug.examples.core.pda.model.PDAThread;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;


/**
 * Renders PDA debug elements
 */
public class PDAModelPresentation extends LabelProvider implements IDebugModelPresentation {
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String attribute, Object value) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof PDADebugTarget) {
			return getTargetText((PDADebugTarget)element);
		} else if (element instanceof PDAThread) {
	        return getThreadText((PDAThread)element);
	    } else if (element instanceof PDAStackFrame) {
	        return getStackFrameText((PDAStackFrame)element);
	    } else if (element instanceof PDAWatchpoint) {
	        return getWatchpointText((PDAWatchpoint)element);
	    }
		return null;
	}
	
	/**
	 * Returns a label for the given watchpoint.
	 * 
     * @param watchpoint
     * @return a label for the given watchpoint
     */
    private String getWatchpointText(PDAWatchpoint watchpoint) {
        try {
	        String label = watchpoint.getVariableName() + " (" + watchpoint.getFunctionName() + ")";
	        if (watchpoint.isAccess()) {
	            label += " [read]";
	        }
	        if (watchpoint.isModification()) {
	            label += " [write]";
	        }
	        return label;
        } catch (CoreException e) {
            return null;
        } 
    }
    /**
	 * Returns a label for the given debug target
	 * 
	 * @param target debug target
	 * @return a label for the given debug target
	 */
	private String getTargetText(PDADebugTarget target) {
		try {
			String pgmPath = target.getLaunch().getLaunchConfiguration().getAttribute(DebugCorePlugin.ATTR_PDA_PROGRAM, (String)null);
			if (pgmPath != null) {
			    IPath path = new Path(pgmPath);
			    String label = "";
			    if (target.isTerminated()) {
			    	label = "<terminated>";
			    }
			    return label + "Lua [" + path.lastSegment() + "]";
			}
		} catch (CoreException e) {
		}
		return "Lua";
		
	}
	
	/**
	 * Returns a label for the given stack frame
	 * 
	 * @param frame a stack frame
	 * @return a label for the given stack frame 
	 */
	private String getStackFrameText(PDAStackFrame frame) {
	    try {
	       return frame.getName() + " (line: " + frame.getLineNumber() + ")"; 
	    } catch (DebugException e) {
	    }
	    return null;

	}
	
	/**
	 * Returns a label for the given thread
	 * 
	 * @param thread a thread
	 * @return a label for the given thread
	 */
	private String getThreadText(PDAThread thread) {
	    String label = thread.getName();
	    if (thread.isStepping()) {
	        label += " (stepping)";
	    } else if (thread.isSuspended()) {
	        IBreakpoint[] breakpoints = thread.getBreakpoints();
	        if (breakpoints.length == 0) {
	        	if (thread.getError() == null) {
	        		label += " (suspended)";
	        	} else {
	        		label += " (" + thread.getError() + ")";
	        	}
	        } else {
	            IBreakpoint breakpoint = breakpoints[0]; // there can only be one in PDA
	            if (breakpoint instanceof PDALineBreakpoint) {
	            	PDALineBreakpoint pdaBreakpoint = (PDALineBreakpoint) breakpoint;
	            	if (pdaBreakpoint instanceof PDAWatchpoint) {
	            	    try {
		            	    PDAWatchpoint watchpoint = (PDAWatchpoint)pdaBreakpoint;
		            	    label += " (watchpoint: " + watchpoint.getSuspendType() + " " + watchpoint.getVariableName() + ")";
	            	    } catch (CoreException e) {
	            	    }
	            	} else if (pdaBreakpoint.isRunToLineBreakpoint()) {
	            		label += " (run to line)";
	            	} else {
	            		label += " (suspended at line breakpoint)";
	            	}
	            }
	        }
	    } else if (thread.isTerminated()) {
	        label = "<terminated> " + label;
	    }
	    return label;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue, org.eclipse.debug.ui.IValueDetailListener)
	 */
	public void computeDetail(IValue value, IValueDetailListener listener) {
		String detail = "";
		try {
			detail = value.getValueString();
		} catch (DebugException e) {
		}
		listener.detailComputed(value, detail);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		if (element instanceof IFile) {
			return new FileEditorInput((IFile)element);
		}
		if (element instanceof ILineBreakpoint) {
			return new FileEditorInput((IFile)((ILineBreakpoint)element).getMarker().getResource());
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput, java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		if (element instanceof IFile || element instanceof ILineBreakpoint) {
			// should come from plugin.xml, johnr
			return "lua.editor";
		}
		return null;
	}
}
