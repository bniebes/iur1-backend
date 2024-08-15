package de.devbn.iu.service.web.iur1;

import de.devbn.iu.service.internal.PlaylistService;
import io.helidon.http.Status;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PlaylistHttpService implements HttpService {

    private static final String PATH_PARAM_DATE = "date";

    private final PlaylistService playlistService;

    @Override
    public void routing(final HttpRules httpRules) {
        httpRules.get("/{date}", this::playlistForDate);
    }

    private void playlistForDate(final ServerRequest req, final ServerResponse res) {
        final var pathParameters = req.path().pathParameters();
        if (!pathParameters.contains(PATH_PARAM_DATE)) {
            sendBadRequest(res);
            return;
        }

        final var maybeDate = playlistService.toDate(pathParameters.get(PATH_PARAM_DATE));
        if (maybeDate.isEmpty()) {
            sendBadRequest(res);
            return;
        }

        final var maybePlaylist = playlistService.playlistOf(maybeDate.get());
        if (maybePlaylist.isEmpty()) {
            res.status(Status.NOT_FOUND_404).send();
            return;
        }

        res.send(maybePlaylist.get());
    }

    private void sendBadRequest(final ServerResponse res) {
        res.status(Status.BAD_REQUEST_400).send();
    }
}
