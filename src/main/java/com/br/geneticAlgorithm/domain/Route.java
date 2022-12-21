package com.br.geneticAlgorithm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Route {

    @Setter
    private List<City> cities;
    private final Random random;

    public Route(List<City> cities, Random random) {
        this.cities = new ArrayList<>(cities);
        this.random = random;
        shuffle();
    }

    private void shuffle () {
        for (int i = 0; i < cities.size() - 1; i++) {
            swap(i, random.nextInt(cities.size() - 1));
        }
    }

    private void swap (int i, int j) {
        City temp = cities.get(i);
        cities.set(i, cities.get(j));
        cities.set(j, temp);
    }
}
