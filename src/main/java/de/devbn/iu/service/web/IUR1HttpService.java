package de.devbn.iu.service.web;

import de.devbn.iu.service.web.iur1.PlaylistHttpService;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class IUR1HttpService implements HttpService {

    private final PlaylistHttpService playlistHttpService;

    @Override
    public void routing(final HttpRules httpRules) {
        httpRules.register("/playlist", playlistHttpService);
    }
}
