package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.ws.annotations.WSEvent;
import com.synload.site.elements.StaticPage;

public class Framework {
	@WSEvent(name="Framework.getFrameworkPage", description="getFrameworkPage", method="get", action="framework", enabled=true)
	public void getFrameworkPage(RequestEvent event) throws JsonProcessingException, IOException{
		event.getSession().send(
			new StaticPage(
				event.getSession(),
				event.getRequest().getTemplateCache(),
				"templates/framework.html",
				"section.content-wrap",
				"index",
				" Framework"
			)
		);
	}
}
