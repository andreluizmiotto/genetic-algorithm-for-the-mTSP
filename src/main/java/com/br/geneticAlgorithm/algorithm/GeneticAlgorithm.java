package com.br.geneticAlgorithm.algorithm;

import com.br.geneticAlgorithm.domain.Chromosome;
import com.br.geneticAlgorithm.domain.City;
import com.br.geneticAlgorithm.domain.Population;
import com.br.geneticAlgorithm.domain.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {

    Population population;
    Population initialPopulation;

    public GeneticAlgorithm(List<City> cities) {
        initialPopulation = generateInitialPopulation(cities);
        population = initialPopulation.deepCopy();
    }

    private Population generateInitialPopulation(List<City> cities) {
        Population population = new Population(100);

        Random random = new Random();

        for (int i = 0; i < population.getMaxSize() - 1; i++) {
            population.add(new Chromosome(List.of(new Route(cities, random))));
        }

        return population;
    }
}
