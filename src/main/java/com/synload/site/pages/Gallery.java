package com.synload.site.pages;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.eventsystem.events.annotations.ES;
import com.synload.framework.ws.annotations.WSEvent;
import com.synload.site.elements.StaticPage;

public class Gallery {
	@ES
	@WSEvent(name="Gallery.getGalleryPage", description="gallery", method="get",action="gallery", enabled = true)
	public void getGalleryPage(RequestEvent event) throws JsonProcessingException, IOException{
		event.getResponse().send(
			new StaticPage(
				event.getRequest().getTemplateCache(),
				"templates/gallery.html",
				"section.header",
				"index",
				" Home"
			)
		);
	}
}
