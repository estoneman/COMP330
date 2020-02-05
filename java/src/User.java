import java.util.*;

public class User {
    public static void main(String[] args) {
        //this class will be used to interact with the user

        String name; //for scoring
        String qType; //(tf,mc,fb,m, or all)

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = keyboard.nextLine();

        System.out.println("Select question type: tf, mc, fb, m, or all"); //eventually we want to only offer q's avaliable from json
        qType = keyboard.nextLine();

        //make switch case statement for each qType


        keyboard.close();

    }
}