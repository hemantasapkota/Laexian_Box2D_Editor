/*******************************************************************************
 * Copyright (c) 2005, 2008 IBM Corporation and others.
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
 *     Retarget to Lua.
 *     Removed perl variables and perl comments.
 *     Added variables to locate ldb and Lua programs in configuration.
******************************************************************************/
package org.eclipse.debug.examples.core.pda;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class DebugCorePlugin extends Plugin {
	//The shared instance.
	private static DebugCorePlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	/**
	 * Unique identifier for the PDA debug model (value 
	 * <code>pda.debugModel</code>).
	 */
	public static final String ID_PDA_DEBUG_MODEL = "pda.debugModel";
	
	/**
	 * Launch configuration attribute key. Value is a path to a perl
	 * program. The path is a string representing a full path
	 * to a Lua program in the workspace. 
	 */
	public static final String ATTR_PDA_PROGRAM = ID_PDA_DEBUG_MODEL + ".ATTR_PDA_PROGRAM";
	
	/**
	 * Identifier for the PDA launch configuration type
	 * (value <code>pda.launchType</code>)
	 */
	public static final String ID_PDA_LAUNCH_CONFIGURATION_TYPE = "pda.launchType";
	
	/**
	 * Launch configuration for the command port
	 */
	public static final String ATTR_LDB_COMMAND_PORT = "ldb.commandport";

	/**
	 * Launch configuration for the event port
	 */
	public static final String ATTR_LDB_EVENT_PORT = "ldb.eventport";

	/**
	 * Launch configuration ip address of where ldb runs
	 */
	public static final String ATTR_LDB_IP_ADDRESS = "ldb.ipaddress";

	/**
	 * Launch configuration full path to ldb
	 */
	public static final String ATTR_LDB_FULL_PATH = "ldb.fullpath";

	/**
	 * Plug-in identifier.
	 */
	public static final String PLUGIN_ID = "org.eclipse.debug.examples.core";
	
	/**
	 * The constructor.
	 */
	public DebugCorePlugin() {
		super();
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
		resourceBundle = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static DebugCorePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = DebugCorePlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		try {
			if (resourceBundle == null)
				resourceBundle = ResourceBundle.getBundle("org.eclipse.debug.examples.core.pda.DebugCorePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
		return resourceBundle;
	}
	
	/**
	 * Return a <code>java.io.File</code> object that corresponds to the specified
	 * <code>IPath</code> in the plugin directory, or <code>null</code> if none.
	 */
	public static File getFileInPlugin(IPath path) {
		try {
			URL installURL =
				new URL(getDefault().getDescriptor().getInstallURL(), path.toString());
			URL localURL = Platform.asLocalURL(installURL);
			return new File(localURL.getFile());
		} catch (IOException ioe) {
			return null;
		}
	}	
}
