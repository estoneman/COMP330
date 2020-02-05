import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import org.json.simple.parser.*;

import java.util.Scanner;

public class User {

    ReadJSONFile readJSONFile = new ReadJSONFile();

    public static void main(String[] args) {
        //this class will be used to interact with the user

        ReadJSONFile readJSONFile = new ReadJSONFile();

        String name; //for scoring
        String qType; //(tf,mc,fb,m, or all)

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = keyboard.nextLine();

        System.out.println("Select question type: tf, mc, fb, m, or all"); //eventually we want to only offer q's avaliable from json
        qType = keyboard.nextLine();

        //make switch case statement for each qType


        System.out.println(JSONHashmap);



        keyboard.close();

    }
}