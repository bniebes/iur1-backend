package de.devbn.iu.util;

import de.devbn.iu.constant.GlobalConstants;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnvironmentUtil {

    public static String getOrDefault(final String key, final String defaultValue) {
        return Optional.ofNullable(System.getenv().get(key)).orElse(defaultValue);
    }

    public static int getOrDefault(final String key, final int defaultValue) {
        try {
            final var valueOrNull = System.getenv().get(key);
            if (Objects.isNull(valueOrNull)) return defaultValue;
            return Integer.parseInt(valueOrNull);
        } catch (NumberFormatException nfEx) {
            log.atWarn()
                    .addMarker(GlobalConstants.MARKER_UTIL)
                    .setMessage("could not convert value for key [{}], returning default value")
                    .addArgument(key)
                    .log();
            return defaultValue;
        }
    }

    private EnvironmentUtil() {}
}
