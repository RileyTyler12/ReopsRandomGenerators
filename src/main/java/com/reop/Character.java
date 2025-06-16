package com.reop;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;
import java.util.Calendar;

public class Character {
    //declare variables for the character
    private String fName;
    private String lName;
    private String age;
    private String gender;
    private String race;
    private String physique;
    private String hairLength;
    private String hairColor;
    private String eyeColor;
    private String[] skills = new String[3];
    private String[] traits = new String[3];
    
    //class constructor
    public Character() {
        getRandomCharacterInfo();
    }
    
    //Get methods
    public void getRandomCharacterInfo() {
        //Character Physical Descriptions
        fName = readTextFileAndGetRandomLine("CharacterInfo/names.txt");
        lName = readTextFileAndGetRandomLine("CharacterInfo/names.txt");
        age = readTextFileAndGetRandomLine("CharacterInfo/age.txt");
        gender = readTextFileAndGetRandomLine("CharacterInfo/genders.txt");
        race = readTextFileAndGetRandomLine("CharacterInfo/races.txt");
        physique = readTextFileAndGetRandomLine("CharacterInfo/physique.txt");
        hairLength = readTextFileAndGetRandomLine("CharacterInfo/hairLength.txt");
        hairColor = readTextFileAndGetRandomLine("CharacterInfo/colors.txt");
        eyeColor = readTextFileAndGetRandomLine("CharacterInfo/colors.txt");
        //Skills
        skills[0] = readTextFileAndGetRandomLine("CharacterInfo/skills.txt");
        skills[1] = readTextFileAndGetRandomLine("CharacterInfo/skills.txt");
        skills[2] = readTextFileAndGetRandomLine("CharacterInfo/skills.txt");
        //Traits
        traits[0] = readTextFileAndGetRandomLine("CharacterInfo/traits.txt");
        traits[1] = readTextFileAndGetRandomLine("CharacterInfo/traits.txt");
        traits[2] = readTextFileAndGetRandomLine("CharacterInfo/traits.txt");
    }
    
    public String getCharacterDetails() {
        //make string of details
        String details = "Name: " + fName + " " + lName + "\n"
                + "Age: " + age + "\n"
                + "Gender: " + gender + "\n"
                + "Race: " + race + "\n"
                + "Physique: " + physique + "\n"
                + "Hair Length: " + hairLength + "\n"
                + "Hair Color: " + hairColor + "\n"
                + "Eye Color: " + eyeColor + "\n"
                + "Skills: " + skills[0] + ", " + skills[1] + ", " + skills[2] + "\n"
                + "Traits: " + traits[0] + ", " + traits[1] + ", " + traits[2];
        
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
    
}
