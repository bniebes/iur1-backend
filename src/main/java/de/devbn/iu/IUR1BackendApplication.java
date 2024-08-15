package de.devbn.iu;

import de.devbn.iu.application.Configuration;
import de.devbn.iu.application.HttpServices;
import de.devbn.iu.application.Services;
import de.devbn.iu.constant.GlobalConstants;
import io.helidon.webserver.WebServer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IUR1BackendApplication implements AutoCloseable {

    private final Services services;
    private final HttpServices httpServices;
    private final int port;

    public IUR1BackendApplication() {
        final var configuration = new Configuration();
        this.services = new Services(configuration);
        this.httpServices = new HttpServices(services);
        this.port = configuration.webServerConfiguration.port();
    }

    public void start() {
        WebServer.builder()
                .port(port)
                .routing(routing -> routing.get("/", (request, response) -> response.send("IUR1 Backend"))
                        .register("/iur1", httpServices.iur1HttpService))
                .build()
                .start();
    }

    @Override
    public void close() throws Exception {
        services.close();
    }

    public static void main(String[] args) {
        try (final var app = new IUR1BackendApplication()) {
            app.start();
        } catch (Exception ex) {
            log.atError()
                    .addMarker(GlobalConstants.MARKER_APPLICATION)
                    .setMessage("Unexpected exception")
                    .setCause(ex)
                    .log();
        }
    }
}
