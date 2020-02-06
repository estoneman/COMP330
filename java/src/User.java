import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import java.io.FileReader;
//import org.json.simple.parser.*;

//https://howtodoinjava.com/library/json-simple-read-write-json-examples/

import java.util.Scanner;

//public class User extends ReadJSONFile {
public class User  {

//    ReadJSONFile readJSONFile = new ReadJSONFile();
//    private HashMap<String, String> JSONHashMap;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //this class will be used to interact with the user

//        ReadJSONFile readJSONFile = new ReadJSONFile();

//        String name; //for scoring
        String qType = ""; //(tf,mc,fb,m, or all)
        String userChoice; //between (A)Create a quiz or (B)Take a quiz

        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Please enter your name: ");
//        name = keyboard.nextLine();

        System.out.println("Would you like to (A)Create a quiz or (B)Take a quiz?"); //or (C)Exit
        userChoice = keyboard.nextLine();

        if (userChoice.equalsIgnoreCase("A")) {
            //Ask reader for q's and a's and format them into JSON file
            JSONObject trueFalseQuestionDetails = new JSONObject();
            JSONObject tFQuestionObject = new JSONObject();
            JSONObject mCQuestionDetails = new JSONObject();
            JSONObject mCQuestionObject = new JSONObject();
            JSONArray mCArray = new JSONArray();

            String question, answer, option, numOptions, numQuestions, userPermission;
            boolean creating = true;
            //for multiple choice questions and matching


            while (creating) {
                System.out.println("What kind of question would you like to add?\n1. tf\n2. mc\n3. fb\n4. m");
                qType = keyboard.nextLine();

                switch (qType) {
                    case "tf":
                        //will be later put in a loop to keep asking until user wants to quit
                        //asks user for the question they would like to add
                        System.out.println("how many questions would you like to add");
                        numQuestions = keyboard.nextLine();
                        for (int k = 0; k < Integer.parseInt(numQuestions); k++) {
                            System.out.println("Type the true/false question you would like to add: ");
                            question = keyboard.nextLine();

                            //asks user for the answer to the above question
                            System.out.println("Type the answer to that question: ");
                            answer = keyboard.nextLine();

                            //puts the question and answer as a key value pair in a map like system to JSONFile to be written later
                            trueFalseQuestionDetails.put(question, answer);
                        }

                        break;

                    case "mc":
                        System.out.println("how many questions would you like to add?: ");
                        numQuestions = keyboard.nextLine();

                        //loops through however many times user wants
                        //maybe we change this to while loop so user has more control over data input?
                        for (int i = 0; i < Integer.parseInt(numQuestions); i++) {
                            System.out.println("Type the multiple choice question you would like to add");
                            question = keyboard.nextLine();

                            System.out.println("How many options would you like to have?: ");
                            numOptions = keyboard.nextLine();

                            for (int j = 1; j < Integer.parseInt(numOptions) + 1; j++) {
                                System.out.println("Enter option " + j + ": ");
                                option = keyboard.nextLine();
                                mCQuestionDetails.put(j + ". ", option);//puts choice number and option as key value pair into json file
                            }

                            System.out.println("Enter the answer: ");
                            answer = keyboard.nextLine();
                            mCQuestionDetails.put("Correct Answer", answer);

                            mCQuestionObject.put(question, mCQuestionDetails);//associates question with all options and correct answer
                        }

                        mCArray.add(mCQuestionObject);//adds to json file as an array for later parsing
                        break;
                    case "fb":
                        break;

                    case "m":
                        break;

                }

                System.out.println("Would you like to add another question type to your quiz?(y/n): ");
                userPermission = keyboard.nextLine();
                if (userPermission.equalsIgnoreCase("y"))
                    continue;
                else {
                    creating = false;
                }

            }


            //writes to the true-false.json file
            //NOTE: it overwrites anything already existing which I think is what we want for a new quiz each time for now
            try {
                //accesses the json file to be written to
                FileWriter trueFalseFile = new FileWriter("/Users/Ethan/AndroidStudioProjects/COMP330/json/trueFalse.json");
                FileWriter multipleChoiceFile = new FileWriter("/Users/Ethan/AndroidStudioProjects/COMP330/json/multipleChoice.json");

                //writes all contents of each JSONObject to their respective json files
                trueFalseFile.write(trueFalseQuestionDetails.toJSONString());
                multipleChoiceFile.write(mCArray.toJSONString());

                //flushes the file of any buffers
                trueFalseFile.flush();
                multipleChoiceFile.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (userChoice.equalsIgnoreCase("B")) {
            System.out.println("Select question type: tf, mc, fb, m, or all");
            //eventually we want to only offer q types avaliable from json
            //and allow users to select multiple q types to form their own quiz, ex tf + fb
            qType = keyboard.nextLine();

            //switch case statement for each qType
            //check if case sensitive!
            switch (qType) {
                case "tf":
                    //test
                    System.out.println("Succesfully chose qType tf");

                    //get tf from hashmap
                    break;

                case "mc":
                    //get mc from hashmap
                    break;

                case "fb":
                    //get fb from hashmap
                    break;

                case "m":
                    //get m from hashmap
                    break;
            }
        }

        else {
            System.out.println("goodbye");
        }

//        JSONHashMap = new HashMap<String, String>();

        //test hashmap
        //System.out.println(JSONHashmap);

        //test keyboard


        keyboard.close();

    }
}