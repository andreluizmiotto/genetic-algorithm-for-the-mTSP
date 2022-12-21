package com.br.geneticAlgorithm.domain;

import com.br.geneticAlgorithm.util.DistanceUtil;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Chromosome implements Comparable<Chromosome> {

    private List<Route> routes;
    private int distance = -1;

    public Chromosome(List<Route> routes) {
        this.routes = routes;
    }

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
