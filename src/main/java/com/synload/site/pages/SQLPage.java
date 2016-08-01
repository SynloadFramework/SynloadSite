package com.synload.site.pages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.eventsystem.events.annotations.ES;
import com.synload.framework.ws.annotations.WSEvent;
import com.synload.site.elements.HTMLPage;
import com.synload.site.sql.Page;

public class SQLPage {
	@ES
	@WSEvent(name="SQLPage.getPage", description="loads page from sql", method="get", action="page", enabled = true)
	public void getPage(RequestEvent event) throws JsonProcessingException, IOException{
		if(event.getRequest().getData().containsKey("page")){
			String page = event.getRequest().getData().get("page");
			Page p;
			try {
				p = Page._find(Page.class, "id=?", page).limit("1").exec(Page.class).get(0);
				event.getResponse().send(
					new HTMLPage(
						event.getRequest().getTemplateCache(),
						p
					)
				);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
