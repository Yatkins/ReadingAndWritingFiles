package edu.ti.caih313.hw4;
import java.util.*;
import java.io.*;

public class SpeciesOutput {
    private static Species[] species;

    public static Species[] initSpecies() {
        String fileName = "src/main/resources/Species.txt";
        Scanner input = null;

        try{
            input = new Scanner(new File(fileName));
            species = new Species[3];
            int count = -1;
            while(input.hasNextLine()){
                count++;
                String line = input.nextLine();
                String[] data = line.split(",");
                String name = data[0];
                int population = Integer.parseInt(data[1]);
                double growthRate = Double.parseDouble(data[2]);
                Species mySpecie = new Species(name, population, growthRate);
                species[count] = mySpecie;
            }
        }
        catch(FileNotFoundException e){
            e.getMessage();
        }
        finally{
            if(input != null){
                input.close();
            }
        }return species;
    }

    public static void writeOutput(){
        String fileName = "src/main/resources/speciesOutput.txt";

        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
            output.writeObject(species);
        }
        catch(FileNotFoundException e){
            e.getMessage();
        }
        catch(IOException e){
            e.getMessage();
        }
        System.out.println("Species written to " + fileName + "\n File closed.");
    }

    public static void main(String[] args){
        SpeciesOutput.initSpecies();
        SpeciesOutput.writeOutput();
    }
}