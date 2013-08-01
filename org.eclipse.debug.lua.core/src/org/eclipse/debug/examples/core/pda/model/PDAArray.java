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
package org.eclipse.debug.examples.core.pda.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;

public class PDAArray extends PDAValue {

	/**
	 * An array splits a value into its words
	 *
	 * @param value existing value 
	 * @throws DebugException 
	 */
	public PDAArray(PDAValue value) throws DebugException {
		super(value.getPDADebugTarget(), value.getValueString());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	public boolean hasVariables() throws DebugException {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IValue#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
		String string = getValueString();
		String[] words = string.split("\\W+");
		IVariable[] variables = new IVariable[words.length];
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			variables[i] = new PDAArrayEntry(getPDADebugTarget(), i, new PDAValue(getPDADebugTarget(), word));
		}
		return variables;
	}

}
