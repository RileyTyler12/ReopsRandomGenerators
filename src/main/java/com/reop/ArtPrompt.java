package com.reop;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;
import java.util.Calendar;

public class ArtPrompt {
    
    //declare variables for the prompt
    private String noun; // a noun for the subject of the prompt
    private String[] adjectives = new String[3]; // 3 adjectives to describe the noun
    
    //class constructor
    public ArtPrompt() {
        getRandomArtPromptInfo();
    }
    
    //Get methods
    public void getRandomArtPromptInfo() {
        //set random noun
        noun = readTextFileAndGetRandomLine("ArtPromptInfo/nouns.txt");
        //set random adjectives
        adjectives[0] = readTextFileAndGetRandomLine("ArtPromptInfo/adjectives.txt");
        adjectives[1] = readTextFileAndGetRandomLine("ArtPromptInfo/adjectives.txt");
        adjectives[2] = readTextFileAndGetRandomLine("ArtPromptInfo/adjectives.txt");
    }
    
    public String getArtPromptDetails() {
        //make string of details
        String details = "A(n) " + adjectives[0] + ", " + adjectives[1] + ", and " + adjectives[2] + " " + noun;
        
        //return string
        return details;
    }
    
    //Read and Write methods
    public String readTextFileAndGetRandomLine(String path) {
        String filePath = path;
        //count the number of lines
        int lineCount = 0;
        //try to read the file
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //get count of lines in text file
            while (br.readLine() != null) {
                lineCount++;
            }
                //close previous buffered reader
            br.close();
            //get random line from text file
            Random random = new Random();
            int targetLineNum = random.nextInt(lineCount);
            String line;
            String returnLine = "";
            br = new BufferedReader(new FileReader(filePath));
            for (int i = 0; (line = br.readLine()) != null; i++) {
                if (i == targetLineNum) {
                    returnLine = line;
                }
            }
                //close previous buffered reader
            br.close();
            //return returnLine
            return returnLine;
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
    
    /* commented out for now until I change it for the art prompt gen
    public void writeCharacterToFile(String input) {
        String fileName;
        Calendar calendar = Calendar.getInstance();
        fileName = "SavedCharacters/SavedCharacter" + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DATE) + calendar.get(Calendar.YEAR) + calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + ".txt";
        //Create File
        File file = new File(fileName);
        try {
            file.createNewFile();
        }
        catch (IOException e) {
            System.out.println("File already exists.");
        }
        //get content
        String content;
        if (input.isEmpty()) {
            content = getCharacterDetails();
        }
        else {
            content = input;
        }
        
        //write to file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    */
    
}
