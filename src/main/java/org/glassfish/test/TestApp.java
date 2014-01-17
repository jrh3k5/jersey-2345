package org.glassfish.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class TestApp {
    public static void main(String[] args) {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(true, TestApp.class.getPackage().getName());
        final HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://0.0.0.0:8080"), resourceConfig);

        final Client client = ClientBuilder.newClient();
        try {
            // System.out.println(String.format("Response: %d", client.target("http://localhost:8080").request().get().getStatus()));
        } finally {
            client.close();
        }

        try {
            httpServer.start();
            while (true) {
                Thread.sleep(50000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
