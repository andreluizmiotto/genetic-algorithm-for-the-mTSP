package com.br.geneticAlgorithm.service;

import com.br.geneticAlgorithm.algorithm.GeneticAlgorithm;
import com.br.geneticAlgorithm.display.DisplayWindow;
import com.br.geneticAlgorithm.domain.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneticAlgorithmService {

    public void run(List<City> cities) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(cities);
        DisplayWindow displayWindow = new DisplayWindow(cities);
    }

}
