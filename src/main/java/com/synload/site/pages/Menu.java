package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.modules.annotations.Event;
import com.synload.framework.modules.annotations.Event.Type;
import com.synload.site.elements.StaticPage;

public class Menu {
	@Event(name="Gallery.getMenu", description="menu",trigger={"get","menu"},flags={},type=Type.WEBSOCKET)
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
