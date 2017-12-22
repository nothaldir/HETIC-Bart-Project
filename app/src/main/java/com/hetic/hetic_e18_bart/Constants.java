package com.hetic.hetic_e18_bart;

/**
 * Created by alex on 20/12/17.
 */

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

final class Constants {

    private Constants() {
    }

    private static final String PACKAGE_NAME = "com.google.android.gms.location.Geofence";

    static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";

    // After this amount of time Location Services stops tracking the geofence.
    private static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;

    static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS = GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    static final float GEOFENCE_RADIUS_IN_METERS = 250;

    static final HashMap<String, LatLng> LANDMARKS = new HashMap<>();

    static {
        // La poste Montreuil
        LANDMARKS.put("LA POSTE", new LatLng(48.852979, 2.418117));

        // Birdie's
        LANDMARKS.put("BIRDIE", new LatLng(48.850907,2.418174));

        // Franprix
        LANDMARKS.put("FRANPRIX", new LatLng(48.844238, 2.431319));

        // HETIC
        LANDMARKS.put("HETIC", new LatLng(48.851804, 2.420575));
    }
}
