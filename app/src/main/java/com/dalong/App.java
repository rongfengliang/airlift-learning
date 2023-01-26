package com.dalong;

import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Module;
import io.airlift.bootstrap.Bootstrap;
import io.airlift.event.client.EventModule;
import io.airlift.http.server.HttpServerModule;
import io.airlift.jaxrs.JaxrsModule;
import io.airlift.json.JsonModule;
import io.airlift.node.NodeConfig;
import io.airlift.node.NodeModule;

import static io.airlift.configuration.ConfigBinder.configBinder;
import static io.airlift.jaxrs.JaxrsBinder.jaxrsBinder;

public class App {
    public static void main(String[] args) {
        Bootstrap app = new Bootstrap(ImmutableList.<Module>builder()
                .add(new NodeModule())
                .add(new Module() {
                    @Override
                    public void configure(Binder binder) {
                        configBinder(binder).bindConfigDefaults(NodeConfig.class, nodeConfig -> {
                           nodeConfig.setEnvironment("test");
                        });
                        jaxrsBinder(binder).bind(MyDemoResource.class);
                    }
                })
                .add(new HttpServerModule())
                .add(new JsonModule())
                .add(new JaxrsModule())
                .add(new EventModule())
                .build());
        app.initialize();
    }
}
