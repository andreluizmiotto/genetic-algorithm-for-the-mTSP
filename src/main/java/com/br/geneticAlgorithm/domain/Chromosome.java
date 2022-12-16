package com.br.geneticAlgorithm.domain;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Chromosome implements Comparable<Chromosome> {

    private List<Route> routes;

    @Override
    public int compareTo(Chromosome chromosome) {
        return routes.size() - chromosome.routes.size();
    }
}
