package com.synload.site;

import com.synload.framework.Log;
import com.synload.framework.modules.ModuleClass;
import com.synload.framework.modules.ModuleLoader;
import com.synload.framework.modules.annotations.Module;

@Module(author="Nathaniel Davidson", name="Synload.com Site", version="0.1")
public class Site extends ModuleClass {

	@Override
	public void crossTalk(Object... arg0) {
		
	}

	@Override
	public void initialize() {
		Log.info("Loadded Synload Site", Site.class);
		ModuleLoader.resources.get("synloadframework").put("index.html", ModuleLoader.resources.get("synloadsite").get("index.html"));
	}

}
