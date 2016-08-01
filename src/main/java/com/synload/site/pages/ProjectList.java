package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.eventsystem.events.annotations.ES;
import com.synload.framework.ws.annotations.WSEvent;
import com.synload.site.elements.StaticPage;

public class ProjectList {
	@ES
	@WSEvent(name="ProjectList.getGalleryPage", description="projectlist",method="get",action="projectlist", enabled = true)
	public void getGalleryPage(RequestEvent event) throws JsonProcessingException, IOException{
		event.getResponse().send(
			new StaticPage(
				event.getRequest().getTemplateCache(),
				"templates/projectImageList.html",
				"section.content-wrap",
				"index",
				" Project List"
			)
		);
	}
}
