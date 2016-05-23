package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.ws.annotations.WSEvent;
import com.synload.site.elements.StaticPage;

public class Blog {
	@WSEvent(name="Blog.getBlogPage", description="getBlogPage",method="get",action="blog",enabled=true)
	public void getBlogPage(RequestEvent event) throws JsonProcessingException, IOException{
		event.getSession().send(
			new StaticPage(
				event.getSession(),
				event.getRequest().getTemplateCache(),
				"templates/blogentry.html",
				"section.content-wrap",
				"index",
				" Blog"
			)
		);
	}
}
