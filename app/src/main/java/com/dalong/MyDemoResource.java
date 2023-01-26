package com.dalong;

import io.airlift.log.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
public class MyDemoResource
{
    private static final Logger log = Logger.get(MyDemoResource.class);

    @GET
    @Path("/v1/info")
    @Produces(APPLICATION_JSON)
    public String getInfo(
            @Context HttpServletRequest servletRequest) {
       return  "dalongdemo";
    }
}
