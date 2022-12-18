package com.br.geneticAlgorithm.domain;

import com.br.geneticAlgorithm.util.DistanceUtil;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Chromosome implements Comparable<Chromosome> {

    private List<Route> routes;
    private int distance = -1;
    private Random random;

    @Override
    public int compareTo(Chromosome chromosome) {
        return routes.size() - chromosome.routes.size();
    }

    public int getDistance () {
        if (distance != -1) {
            return distance;
        }

        double distanceTravelled = 0;

        for (Route route : routes) {
            distanceTravelled += DistanceUtil.calculateDistance(route);
        }

        this.distance = (int) distanceTravelled;
        return distance;
    }
}
