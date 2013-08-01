/*******************************************************************************
 * Copyright (c) 2008 VeriSign, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     VeriSign, Inc. - initial API and implementation
 *     John Rodriguez
 *******************************************************************************/
package luaeditorideplugin;

import org.eclipse.ui.plugin.AbstractUIPlugin;

public class LuaPlugin extends AbstractUIPlugin {
    public final static String MY_PARTITIONING = "___my__partitioning____";

    private static LuaPartitionScanner fPartitionScanner;
    
    public static LuaPartitionScanner getMyPartitionScanner() {
        if (fPartitionScanner == null)
            fPartitionScanner= new LuaPartitionScanner();
        return fPartitionScanner;
    }
}

