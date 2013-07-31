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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ILogicalStructureTypeDelegate;
import org.eclipse.debug.core.model.IValue;

/**
 * Logical stucture to translate a string into its words.
 */
public class WordStructureDelegate implements ILogicalStructureTypeDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILogicalStructureTypeDelegate#providesLogicalStructure(org.eclipse.debug.core.model.IValue)
	 */
	public boolean providesLogicalStructure(IValue value) {
		try {
			String string = value.getValueString();
			String[] words = string.split("\\W+");
			return words.length > 1;
		} catch (DebugException e) {
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILogicalStructureTypeDelegate#getLogicalStructure(org.eclipse.debug.core.model.IValue)
	 */
	public IValue getLogicalStructure(IValue value) throws CoreException {
		return new PDAArray((PDAValue)value);
	}

}
