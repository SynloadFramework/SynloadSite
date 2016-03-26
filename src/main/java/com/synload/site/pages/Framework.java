package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.modules.annotations.Event;
import com.synload.framework.modules.annotations.Event.Type;
import com.synload.site.elements.StaticPage;

public class Framework {
	@Event(name="Framework.getFrameworkPage", description="getFrameworkPage",trigger={"get","framework"},flags={},type=Type.WEBSOCKET)
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
