package de.devbn.iu.configuration;

import de.devbn.iu.util.EnvironmentUtil;

public record PlaylistConfiguration(String directory) {

    private static final String KEY_PLAYLIST_DIRECTORY = "playlist.directory";
    private static final String DEFAULT_PLAYLIST_DIRECTORY = "./data/playlist"; // FIXME

    public static PlaylistConfiguration fromEnvironment() {
        return new PlaylistConfiguration(
                EnvironmentUtil.getOrDefault(KEY_PLAYLIST_DIRECTORY, DEFAULT_PLAYLIST_DIRECTORY));
    }
}
