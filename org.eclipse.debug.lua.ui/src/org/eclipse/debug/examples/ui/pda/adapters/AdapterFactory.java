/*******************************************************************************
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Bjorn Freeman-Benson - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.examples.ui.pda.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.examples.core.pda.model.PDADebugTarget;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelProxyFactory;


/**
 * 
 * @since 3.2
 *
 */
public class AdapterFactory implements IAdapterFactory {
	
	private static IElementContentProvider fgTargetAdapter = new PDADebugTargetContentProvider();
	private static IModelProxyFactory fgFactory = new ModelProxyFactory();

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IElementContentProvider.class.equals(adapterType)) {
			if (adaptableObject instanceof PDADebugTarget) {
				return fgTargetAdapter;
			}
		}
		if (IModelProxyFactory.class.equals(adapterType)) {
			if (adaptableObject instanceof PDADebugTarget) {
				return fgFactory;
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[]{IElementContentProvider.class, IModelProxyFactory.class};
	}

}
