package com.br.geneticAlgorithm.util;

import com.br.geneticAlgorithm.domain.City;
import com.br.geneticAlgorithm.domain.Route;

public final class DistanceUtil {

    private static final double earthRadius = 3958.75;

    public static double calculateDistance(Route route) {
        int distance = 0;

        for (int index = 0; index < route.getCities().size() - 2; index++) {
            distance += calculateDistance(route.getCities().get(index), route.getCities().get(index + 1));
        }

        return distance;
    }

    public static double calculateDistance(City city, City nextCity) {

        double dLat = Math.toRadians(nextCity.getLocation().getLatitude() - city.getLocation().getLatitude());
        double dLng = Math.toRadians(nextCity.getLocation().getLongitude() - city.getLocation().getLongitude());

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(city.getLocation().getLatitude())) * Math.cos(Math.toRadians(nextCity.getLocation().getLatitude())) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        int meterConversion = 1609;

        return dist * meterConversion;
    }
}
