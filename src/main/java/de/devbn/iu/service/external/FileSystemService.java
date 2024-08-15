package de.devbn.iu.service.external;

import de.devbn.iu.constant.GlobalConstants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FileSystemService {

    public Optional<String> loadJsonFromFile(final Path path) {
        try {
            return Optional.of(Files.readString(path));
        } catch (IOException ioEx) {
            log.atError()
                    .addMarker(GlobalConstants.MARKER_SERVICE)
                    .addMarker(GlobalConstants.MARKER_EXTERNAL)
                    .setMessage("could not load json from file at [{}]")
                    .addArgument(path)
                    .setCause(ioEx)
                    .log();
            return Optional.empty();
        }
    }
}
