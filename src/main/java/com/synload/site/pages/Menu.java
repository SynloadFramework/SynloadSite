package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.ws.annotations.WSEvent;
import com.synload.site.elements.StaticPage;

public class Menu {
	@WSEvent(name="Gallery.getMenu", description="menu",method="get",action="menu",enabled=true)
	public void getGalleryPage(RequestEvent event) throws JsonProcessingException, IOException{
		event.getSession().send(
			new StaticPage(
				event.getSession(),
				event.getRequest().getTemplateCache(),
				"templates/menu.html",
				"div.menu",
				"index",
				" Home"
			)
		);
	}
}
