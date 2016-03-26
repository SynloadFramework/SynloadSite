package com.synload.site.elements;

import java.io.UnsupportedEncodingException;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
		Map<String, String> l = new HashMap<String, String>();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			l.put("modules", ow.writeValueAsString(ModuleLoader.jar.values()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		this.setData(l);
		this.setParent(parent);
		this.setParentTemplate(parentTemplate);
		this.setAction("alone");
		this.setPageId("staticpage["+page+"]");
		this.setPageTitle(title);
	}
}
