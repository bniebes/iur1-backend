package de.devbn.iu.service.web;

import de.devbn.iu.service.web.iur1.PlaylistHttpService;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class IUR1HttpService implements HttpService {

    private final PlaylistHttpService playlistHttpService;

    @Override
    public void routing(final HttpRules httpRules) {
        httpRules.get("/health", this::health)
                .register("/playlist", playlistHttpService);
    }

    private void health(final ServerRequest req, final ServerResponse res) {
        res.send("UP");
    }
}
