package com.synload.site.http;

import com.synload.framework.Log;
import com.synload.framework.http.HttpRequest;
import com.synload.framework.http.annotations.Get;
import com.synload.framework.http.annotations.MimeType;
import com.synload.framework.modules.ModuleResource;

import java.io.IOException;

/**
 * Created by Nathaniel on 5/23/2016.
 */
public class Index {
    @Get("/") // HTTP get annotation ( registers as get request http://yoursite.com:8080/template )
    @MimeType("text/html") // returns OK from server and the mimetype content type
    public void gHtml(HttpRequest hr){
        hr.getResponse().setContentLength(ModuleResource.get("synloadsite","index.html").length);
        try {
            hr.getResponse().getOutputStream().write(ModuleResource.get("synloadsite","index.html"));
        } catch (IOException e) {
            Log.info(e.getMessage(), Index.class);
        }
    }
}