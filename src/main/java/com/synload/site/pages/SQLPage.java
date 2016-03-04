package com.synload.site.pages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.modules.annotations.Event;
import com.synload.framework.modules.annotations.Event.Type;
import com.synload.site.elements.HTMLPage;
import com.synload.site.sql.Page;

public class SQLPage {
	@Event(name="SQLPage.getPage", description="loads page from sql",trigger={"get","page"},flags={},type=Type.WEBSOCKET)
	public void getPage(RequestEvent event) throws JsonProcessingException, IOException{
		if(event.getRequest().getData().containsKey("page")){
			String page = event.getRequest().getData().get("page");
			Page p;
			try {
				p = Page._find(Page.class, "id=?", page).limit("1").exec(Page.class).get(0);
				event.getSession().send(
					new HTMLPage(
						event.getSession(),
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
