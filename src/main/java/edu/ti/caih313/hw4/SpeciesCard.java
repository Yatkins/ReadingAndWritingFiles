package edu.ti.caih313.hw4;

import java.io.*;

public class SpeciesCard {

        public static Species[] readInput(){
            String fileName = "src/main/resources/speciesOutput.txt";
            Species[] inputSpecies = null;

            try{
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
                inputSpecies = (Species[]) input.readObject();
            }
            catch(FileNotFoundException e){
                e.getMessage();
            }
            catch(IOException e){
                e.getMessage();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }return inputSpecies;
        }

        public static void writeToCard(Species[] inputSpecies){
            while(inputSpecies != null) {
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter("src/main/resources/speciesCards.txt");
                    for (int i = 0; i < inputSpecies.length; i++) {
                        printWriter.println("Name: " + inputSpecies[i].getName() +
                                "\n Population: " + inputSpecies[i].getPopulation() +
                                "\n Growth rate: " + inputSpecies[i].getGrowthRate() + "%");
                    }
                } catch (FileNotFoundException e) {
                    e.getMessage();
                } catch(NullPointerException e){
                    e.getMessage();
                }finally {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                }
            }
        }

        public static void main(String[] args){
            Species[] speciesArray;
                speciesArray = SpeciesCard.readInput();
                SpeciesCard.writeToCard(speciesArray);
        }
}

