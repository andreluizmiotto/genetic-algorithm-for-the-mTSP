package com.br.geneticAlgorithm.controller;

import com.br.geneticAlgorithm.domain.City;
import com.br.geneticAlgorithm.service.GeneticAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("genetic-algorithm")
public class GeneticAlgorithmController {

    @Autowired
    GeneticAlgorithmService geneticAlgorithmService;

    @PostMapping(value = "/run")
    public void roteirizarPayloadSync(@RequestBody List<City> cities) {
        try {
            geneticAlgorithmService.run(cities);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
