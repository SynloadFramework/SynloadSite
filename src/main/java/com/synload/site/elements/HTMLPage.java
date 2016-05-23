package com.synload.site.elements;

import java.io.UnsupportedEncodingException;
import java.util.List;
import com.synload.framework.handlers.Response;
import com.synload.framework.modules.ModuleLoader;
import com.synload.framework.modules.ModuleResource;
import com.synload.framework.ws.WSHandler;
import com.synload.site.sql.Page;

public class HTMLPage extends Response {
	public HTMLPage(WSHandler user, List<String> templateCache, Page page){
		this.setTemplateId("htmlp["+page.getId()+"]");
		if(!templateCache.contains(this.getTemplateId())){
			try {
				this.setTemplate(this.getTemplate(new String(ModuleResource.get("synloadsite", page.getTemplate()),"UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		this.setParent(page.getParent());
		this.setParentTemplate(page.getParentTemplate());
		this.setAction("alone");
		this.setPageId("htmlpage["+page.getId()+"]");
		this.setPageTitle(page.getTitle());
	}
}
