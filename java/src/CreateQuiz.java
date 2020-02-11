import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreateQuiz {

    //file paths for my (Ethan's) computer
    String TRUE_FALSE_PATH = "/Users/Ethan/StudioProjects/COMP330/json/trueFalse.json";
    String MULTIPLE_CHOICE_PATH = "/Users/Ethan/StudioProjects/COMP330/json/multipleChoice.json";
    String FILL_IN_BLANK_PATH = "/Users/Ethan/StudioProjects/COMP330/json/fillInBlank.json";
    String MATCHING_PATH = "/Users/Ethan/StudioProjects/COMP330/json/matching.json";

    FileWriter fileWriter;//single file writer that writes to all of our json files

    Scanner keyboard = new Scanner(System.in);

    //method that asks user for input
    @SuppressWarnings("unchecked")
    public void userInput() {
        JSONObject questionDetails;
        JSONObject questionObject = new JSONObject();
        JSONArray questionArray = new JSONArray();

        String qType = "";//question type that the user will type in
        String answer, option, numOptions, numQuestions, userPermission;
        String question = "";//actual question the user will type in
        String multipleChoiceKeyString = "";

        boolean creating = true;//loop control for the entire creating process
        boolean creatingTrueFalse = true;//loop control for creating true false questions
        boolean creatingMultipleChoice = true;//loop control for creating multiple choice questions
        boolean creatingOptions = true;//loop control for creating options in multiple choice questions
        boolean creatingFillInBlank = true;//loop control for creating fill in the blank questions
        boolean creatingMatching = true;//loop control for creating matching questions

        int loopCounter;//for number of options for multiple choice

        ArrayList<String> arrayList;

        while (creating) {
            loopCounter = 0;

            System.out.println("What kind of question would you like to add?\n1. tf\n2. mc\n3. fb\n4. m");
            qType = keyboard.nextLine();

            if (qType.equalsIgnoreCase("quit"))
                creating = false;

            switch (qType) {
                case "tf":
                    //these two lines avoids any duplicate strings to be written to json files by emptying the contents each time a new question set is created
                    questionArray = new JSONArray();
                    questionObject = new JSONObject();

                    while (creatingTrueFalse) {

                        questionDetails = new JSONObject();//initializes the JSONObject to be added to the JSONArray so there are no duplicate objects
                        System.out.println("Enter the true/false question you would like to add\nEnter 'quit' to stop adding true/false questions: ");
                        question = keyboard.nextLine();

                        //user will get out of creating true false questions if they enter 'quit' so they have full control
                        if (question.equalsIgnoreCase("quit"))
                            creatingTrueFalse = false;

                        else {
                            System.out.println("Type the answer to '" + question + "': ");
                            answer = keyboard.nextLine();

                            questionDetails.put(question, answer);//packs the question and answer into its own unique JSONObject
                            questionArray.add(questionDetails);//adds the above JSONObject to an array of JSONObjects

                        }

                    }

                    questionObject.put(qType, questionArray);//puts the key as "tf" and the value as the JSONArray of JSONObjects with questions and answer as key, value pair

                    writeToFile(TRUE_FALSE_PATH, questionObject);//writes the entire packed question object to the specified file
                    break;

                case "mc":
                    //these two lines avoids any duplicate strings to be written to json files by emptying the contents each time a new question set is created
                    questionArray = new JSONArray();
                    questionObject = new JSONObject();

                    arrayList = new ArrayList<String>();//for checking duplicate options

                    while (creatingMultipleChoice) {
                        questionDetails = new JSONObject();
                        creatingOptions = true;

                        System.out.println("Enter the multiple choice question you would like to add\nEnter 'quit' to stop adding multiple choice questions: ");
                        question = keyboard.nextLine();

                        //this string will be used as the key in the key, value pair of each object within the array stored in multipleChoice.json
                        multipleChoiceKeyString = question;

                        if (question.equalsIgnoreCase("quit"))
                            creatingMultipleChoice = false;

                        else {
                            //controls how many options the user wants to create
                            while (creatingOptions) {

                                System.out.println("Enter option or enter nothing to stop adding options: ");
                                option = keyboard.nextLine();

                                arrayList.add(option);

                                if (option.equals(""))
                                    creatingOptions = false;
                                else {
                                    multipleChoiceKeyString += " " + option;//concatenates option to the end of the question in order to fit our consistent question modeling
                                }
                            }

                            System.out.println("Enter the answer to '" + question + "': ");
                            answer = keyboard.nextLine();

                            //makes sure the user enters an answer that is part of the option set
                            while (!arrayList.contains(answer)) {
                                System.out.println(answer + " is not in the option set, enter the answer again: ");
                                answer = keyboard.nextLine();
                            }

                            questionDetails.put(multipleChoiceKeyString, answer);//packs the question and answer into its own unique JSONObject
                            questionArray.add(questionDetails);//adds the above JSONObject to an array of JSONObjects

                        }
                    }

                    questionObject.put(qType, questionArray);//puts the key as "mc" and the value as the JSONArray of JSONObjects with questions and answer as key, value pair

                    writeToFile(MULTIPLE_CHOICE_PATH, questionObject);
                    break;

                case "fb":
                    //these two lines avoids any duplicate strings to be written to json files by emptying the contents each time a new question set is created
                    questionArray = new JSONArray();
                    questionObject = new JSONObject();

                    while (creatingFillInBlank) {

                        questionDetails = new JSONObject();//initializes the JSONObject to be added to the JSONArray so there are no duplicate objects
                        System.out.println("Enter the fill-in-the-blank question\nEnter 'quit' when finished: ");
                        question = keyboard.nextLine();

                        if (question.equalsIgnoreCase("quit"))
                            creatingFillInBlank = false;

                        else {
                            System.out.println("Type the answer to '" + question + "': ");
                            answer = keyboard.nextLine();

                            questionDetails.put(question, answer);//packs the question and answer into its own unique JSONObject
                            questionArray.add(questionDetails);//adds the above JSONObject to an array of JSONObjects

                        }

                    }

                    questionObject.put(qType, questionArray);//puts the key as "fb" and the value as the JSONArray of JSONObjects with questions and answer as key, value pair

                    writeToFile(FILL_IN_BLANK_PATH, questionObject);
                    break;

                case "m":

                    questionArray = new JSONArray();
                    questionObject = new JSONObject();

                    while (creatingMatching) {

                        questionDetails = new JSONObject();

                        System.out.println("Enter a term that you wish to match with another term\nEnter 'quit' when finished: ");
                        question = keyboard.nextLine();

                        if (question.equalsIgnoreCase("quit"))
                            creatingMatching = false;
                        else {
                            System.out.println("Enter the match to " + question);
                            answer = keyboard.nextLine();

                            questionDetails.put(question, answer);
                            questionArray.add(questionDetails);
                        }
                    }

                    questionObject.put("matching", questionArray);

                    writeToFile(MATCHING_PATH, questionObject);

                    break;

            }

            System.out.println("Would you like to add another question type?(y/n): ");
            userPermission = keyboard.nextLine();

            if (userPermission.equalsIgnoreCase("n"))
                creating = false;
            else
                continue;

        }

        keyboard.close();

    }

    //main method to be run by User.java main(String[] args) method
    public void createQuiz() {

    }

    //writes to given file with given JSONObject
    public void writeToFile(String filePath, JSONObject jsonObject) {
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonObject.toJSONString());

            fileWriter.flush();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        new CreateQuiz().userInput();
    }

}