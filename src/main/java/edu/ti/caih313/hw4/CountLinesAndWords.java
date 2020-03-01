package edu.ti.caih313.hw4;
import java.util.*;
import java.io.*;

public class CountLinesAndWords {

    public static void main(String[] args){
        String fileName = "src/main/resources/Species.txt";
        System.out.println("The file" + fileName + "\n contains: \n");
        Scanner input = null;

        int totalWords = 0;
        int totalLines = 0;
        int totalChar = 0;

        try{
            input = new Scanner(new File(fileName));
            while(input.hasNextLine()){
                totalLines++;
                String line = input.nextLine();
                String[] words = line.split(" ");
                totalWords = words.length;
                for(int i = 0; i < words.length; i++){
                    totalChar += words[i].length();
                }
            }
            System.out.println("Total lines: " + totalLines + " Total words: " + totalWords + " Total characters " + totalChar);
        }
        catch (FileNotFoundException e){
                System.out.println("Error opening the file " + fileName + ": " + e.getMessage());
        }
        finally{
            if(input != null){
                input.close();
            }
        }
    }
}
