package edu.ti.caih313.hw4;
 import java.io.Serializable;

public class Species implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    private int population;
    private double growthRate;

    public Species(String name, int initialPopulation, double growthRate) {
        this.name = name;
        if (initialPopulation >= 0) {
            this.population = initialPopulation;
        } else {
            throw new IllegalArgumentException("initial population is less than zero");
        }
        this.growthRate = growthRate;
    }

    public String toString() {
        return ("Name = " + name + "\n" +
                "Population = " + population + "\n" +
                "Growth rate = " + growthRate + "%");
    }
}
