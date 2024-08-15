package de.devbn.iu.constant;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class GlobalConstants {

    public static final Marker MARKER_APPLICATION = MarkerFactory.getMarker("application");
    public static final Marker MARKER_SERVICE = MarkerFactory.getMarker("service");
    public static final Marker MARKER_UTIL = MarkerFactory.getMarker("util");

    public static final Marker MARKER_EXTERNAL = MarkerFactory.getMarker("external");
    public static final Marker MARKER_INTERNAL = MarkerFactory.getMarker("internal");

    private GlobalConstants() {}
}
