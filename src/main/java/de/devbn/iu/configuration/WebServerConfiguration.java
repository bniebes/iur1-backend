package de.devbn.iu.configuration;

import de.devbn.iu.application.EnvironmentAccessor;

public record WebServerConfiguration(int port) {

    private static final String KEY_WEB_SERVER_PORT = "web.server.port";
    private static final int DEFAULT_WEB_SERVER_PORT = 30123;

    public static WebServerConfiguration from(final EnvironmentAccessor environmentAccessor) {
        return new WebServerConfiguration(environmentAccessor.getOrDefault(
                KEY_WEB_SERVER_PORT, DEFAULT_WEB_SERVER_PORT, EnvironmentAccessor::mapToInt));
    }
}
