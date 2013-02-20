/**
 * Copyright 2007-2010 非也
 * All rights reserved. 
 * 
 * This library is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License v3 as published by the Free Software
 * Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, see http://www.gnu.org/licenses/lgpl.html.
 *
 */
package org.fireflow.engine.modules.env.impl;

import java.io.File;

import org.fireflow.engine.context.AbsEngineModule;
import org.fireflow.engine.context.RuntimeContext;
import org.fireflow.engine.exception.EngineException;
import org.fireflow.engine.modules.env.Environment;

/**
 * 该类一般做测试用
 * @author 非也 nychen2000@163.com
 * Fire Workflow 官方网站：www.firesoa.com 或者 www.fireflow.org
 *
 */
public class Enviroment4J2SE  extends AbsEngineModule implements Environment {
	String webserviceContextPath = "http://127.0.0.1:3069/FireWorkflowServices/";
	String workspaceDirName = null;
	public void init(RuntimeContext runtimeContext){
		String userDir = System.getProperty("user.dir");
		workspaceDirName = userDir+File.separator+WORK_DIR_NAME;
		File f = new File(workspaceDirName);
		if(!f.exists()){
			boolean b = f.mkdir();
			if (!b){
				throw new EngineException("Create fire workflow workspace failed; the workspace dir name is '"+workspaceDirName+"'");
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.fireflow.engine.modules.env.Environment#getWorkDir()
	 */
	@Override
	public String getWorkDir() {

		return workspaceDirName;
	}

	/* (non-Javadoc)
	 * @see org.fireflow.engine.modules.env.Environment#getWebServiceContextPath()
	 */
	@Override
	public String getWebserviceContextPath() {
		return webserviceContextPath;
	}
	
	public void setWebserviceContextPath(String path){
		this.webserviceContextPath = path;
	}

}
