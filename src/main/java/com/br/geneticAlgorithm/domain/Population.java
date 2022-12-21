package com.br.geneticAlgorithm.domain;

import lombok.Getter;

import java.nio.BufferOverflowException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Population implements Iterable<Chromosome> {

    private PriorityQueue<Chromosome> chromosomes;

    @Getter
    private final int maxSize;

    public Population(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public Iterator<Chromosome> iterator() {
        return chromosomes.iterator();
    }

    @Override
    public void forEach(Consumer<? super Chromosome> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Chromosome> spliterator() {
        return Iterable.super.spliterator();
    }

    public void add (Chromosome chromosome) {
        if (chromosomes.size() == maxSize) {
            throw new BufferOverflowException();
        }
        chromosomes.add(chromosome);
    }

    public Population deepCopy () {
        Population population = new Population(maxSize);
        chromosomes.forEach(population::add);
        return population;
    }

    public Chromosome getMostFit () {
        return chromosomes.peek();
    }

    public int getAverageDistance () {

        int averageDistance = 0;

        for (Chromosome chromosome : chromosomes) {
            averageDistance += chromosome.getDistance();
        }

        return averageDistance / chromosomes.size();
    }

}
