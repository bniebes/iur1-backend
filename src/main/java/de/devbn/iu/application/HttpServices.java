package de.devbn.iu.application;

import de.devbn.iu.constant.GlobalConstants;
import de.devbn.iu.service.web.IUR1HttpService;
import de.devbn.iu.service.web.iur1.PlaylistHttpService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpServices {

    public final IUR1HttpService iur1HttpService;

    public HttpServices(final Services services) {
        log.atInfo()
                .addMarker(GlobalConstants.MARKER_APPLICATION)
                .setMessage("Set-Up")
                .log();
        final var playlistHttpService = new PlaylistHttpService(services.playlistService);

        this.iur1HttpService = new IUR1HttpService(playlistHttpService);
    }
}
