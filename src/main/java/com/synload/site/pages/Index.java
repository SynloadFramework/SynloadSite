package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.modules.annotations.Event;
import com.synload.framework.modules.annotations.Event.Type;
import com.synload.site.elements.StaticPage;

public class Index {
	@Event(name="Index.getIndex", description="index",trigger={"get","index"},flags={},type=Type.WEBSOCKET)
	public void getIndex(RequestEvent event) throws JsonProcessingException, IOException{
		event.getSession().send(
			new StaticPage(
				event.getSession(),
				event.getRequest().getTemplateCache(),
				"index.html",
				"div[page='wrapper']",
				"wrapper",
				"Synload Home"
			)
		);
	}
}
