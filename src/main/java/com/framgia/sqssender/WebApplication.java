package com.framgia.sqssender;

import com.framgia.sqssender.resource.ApiResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * @author: Linh Nguyen The
 * @email: nguyen.the.linhb@framgia.com
 * @company: Framgia
 * Copyright (c) Framgia 2018
 * Create 04/06/2018
 */
public class WebApplication extends Application<WebApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new WebApplication().run(args);
    }

    public void run(WebApplicationConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(ApiResource.class);
    }
}
