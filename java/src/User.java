<<<<<<< HEAD
import java.util.*;
=======
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import java.io.FileReader;
//import org.json.simple.parser.*;

import java.util.Scanner;
>>>>>>> 3a8fa28a7f878879c036d3ba6a1d6cb265771f4e

//public class User extends ReadJSONFile {
public class User  {

//    ReadJSONFile readJSONFile = new ReadJSONFile();
//    private HashMap<String, String> JSONHashMap;

    public static void main(String[] args) {
        //this class will be used to interact with the user

//        ReadJSONFile readJSONFile = new ReadJSONFile();

        String name; //for scoring
        String qType = null; //(tf,mc,fb,m, or all)
        String userChoice; //between (A)Create a quiz or (B)Take a quiz

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = keyboard.nextLine();

        System.out.println("Would you like to (A)Create a quiz or (B)Take a quiz?"); //or (C)Exit
        userChoice = keyboard.nextLine();

        if (userChoice.equalsIgnoreCase("A")) {
            //Ask reader for q's and a's and format them into JSON file

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

//        JSONHashMap = new HashMap<String, String>();

        //test hashmap
        //System.out.println(JSONHashmap);

<<<<<<< HEAD
=======

        //test keyboard
        System.out.println(name);
        System.out.println(userChoice);
        System.out.println(qType);

>>>>>>> 3a8fa28a7f878879c036d3ba6a1d6cb265771f4e
        keyboard.close();

    }
}