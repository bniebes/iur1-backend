package de.devbn.iu.application;

import de.devbn.iu.constant.GlobalConstants;
import de.devbn.iu.service.external.FileSystemService;
import de.devbn.iu.service.internal.PlaylistService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Services implements AutoCloseable {

    public final PlaylistService playlistService;

    public Services(final Configuration configuration) {
        log.atInfo()
                .addMarker(GlobalConstants.MARKER_APPLICATION)
                .setMessage("Set-Up")
                .log();
        final var fileSystemService = new FileSystemService();

        this.playlistService = new PlaylistService(configuration.playlistConfiguration, fileSystemService);
    }

    @Override
    public void close() throws Exception {}
}
