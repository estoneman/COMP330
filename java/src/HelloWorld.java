import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import org.json.simple.parser.*;

import java.util.*;

//Inspriation from: https://www.geeksforgeeks.org/parse-json-java/

//in order for these import statements to work I used the following linux command:
//export CLASSPATH=$CLASSPATH:/path/to/json-simple.jar/file

class HelloWorld {

    private static HashMap<String, String> trueFalseHashMap;

    public HelloWorld() {
        trueFalseHashMap = new HashMap<String, String>();
    }

    private HashMap<String, String> populateHashmap() {

        try {
            //read json file into this class in order to parse
            Object fileRead = new JSONParser().parse(new FileReader("/Users/Ethan/AndroidStudioProjects/COMP330/json/sample.json"));

            // typecasting obj to JSONObject in order to use JSONSimple library
            JSONObject jsonObject = (JSONObject) fileRead;

            //getting our T/F question; in this case we stored the question and answers as array
            JSONArray trueFalseArray = (JSONArray) jsonObject.get("tf");

            //to iterate through objects in array of t/f
            Iterator<?> iter = trueFalseArray.iterator();

            //for accessing the objects inside trueFalseArray and converting to Strings
            //for the purpose of parsing by indexing of each String element
            String questionAnswerPair;

            //for separating questions and answers into their own index for easier parsing
            String[] questionAnswerArray;

            //iterates through the JSONArray and populates true false hash map
            while (iter.hasNext()) {
                questionAnswerArray = parseTFObject(iter.next());

                String question = questionAnswerArray[0].substring(5, questionAnswerArray[0].length() - 1);//gets rid of unneeded characters
                String answer = questionAnswerArray[1].substring(5, questionAnswerArray[1].length() - 1);//gets rid of unneeded characters

                trueFalseHashMap.put(question, answer);//populates the hash map with correct values
            }

        }

        catch(Exception e) {
            System.out.println(e);
        }

        return trueFalseHashMap;//populated hash map with questions and answers of the true false section in json file

    }

    private String[] parseTFObject(Object obj) {
        String objString = obj.toString();//converts iter.next() which is of type Object to String
        objString = objString.substring(1, objString.length() - 1);//gets rid of leading and trailing braces in string
        String[] result = objString.split(",");//puts elements into their own index for easier parsing
        return result;
    }

}
