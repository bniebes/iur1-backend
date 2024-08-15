package de.devbn.iu.application;

import de.devbn.iu.configuration.PlaylistConfiguration;
import de.devbn.iu.configuration.WebServerConfiguration;
import de.devbn.iu.constant.GlobalConstants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Configuration {

    public final WebServerConfiguration webServerConfiguration;
    public final PlaylistConfiguration playlistConfiguration;

    public Configuration() {
        log.atInfo()
                .addMarker(GlobalConstants.MARKER_APPLICATION)
                .setMessage("Load configuration")
                .log();
        this.webServerConfiguration = WebServerConfiguration.fromEnvironment();
        this.playlistConfiguration = PlaylistConfiguration.fromEnvironment();
    }
}
