package de.devbn.iu.service.internal;

import de.devbn.iu.configuration.PlaylistConfiguration;
import de.devbn.iu.constant.GlobalConstants;
import de.devbn.iu.service.external.FileSystemService;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistConfiguration playlistConfiguration;
    private final FileSystemService fileSystemService;

    public Optional<LocalDate> toDate(final String dateString) {
        try {
            return Optional.of(LocalDate.parse(dateString));
        } catch (DateTimeParseException dtpEx) {
            return Optional.empty();
        }
    }

    public Optional<String> playlistOf(final LocalDate date) {
        try {
            final var path = Path.of(playlistConfiguration.directory(), "%s.json".formatted(date.toString()));
            return fileSystemService.loadJsonFromFile(path);
        } catch (InvalidPathException ipEx) {
            log.atError()
                    .addMarker(GlobalConstants.MARKER_SERVICE)
                    .addMarker(GlobalConstants.MARKER_INTERNAL)
                    .setMessage("could not create path for playlist file")
                    .setCause(ipEx)
                    .log();
            return Optional.empty();
        }
    }
}
