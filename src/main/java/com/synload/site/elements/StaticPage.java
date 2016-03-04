package com.synload.site.elements;

import java.io.UnsupportedEncodingException;
import java.util.List;
import com.synload.framework.handlers.Response;
import com.synload.framework.modules.ModuleLoader;
import com.synload.framework.ws.WSHandler;

public class StaticPage extends Response {
	public StaticPage(WSHandler user, List<String> templateCache, String page, String parent, String parentTemplate, String title){
		this.setTemplateId("staticp["+page+"]");
		if(!templateCache.contains(this.getTemplateId())){
			try {
				this.setTemplate(this.getTemplate(new String(ModuleLoader.resources.get("synloadsite").get(page),"UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		this.setParent(parent);
		this.setParentTemplate(parentTemplate);
		this.setAction("alone");
		this.setPageId("staticpage["+page+"]");
		this.setPageTitle(title);
	}
}
