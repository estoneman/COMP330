import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import org.json.simple.parser.*;

import java.util.*;

//Inspriation from: https://www.geeksforgeeks.org/parse-json-java/

//in order for these import statements to work I used the following linux command:
//export CLASSPATH=/path/to/json-simple.jar/file
//having an issue where I cannot run the HelloWorld object it compiles fine and everything it just will not run
//returns a java.lang.ClassNotFoundException every time

class HelloWorld {

    public static void main(String[] args) {

        try {
            Object obj = new JSONParser().parse(new FileReader("/Users/Ethan/AndroidStudioProjects/COMP330/json/sample.json"));

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            JSONArray ja = (JSONArray) jo.get("tf");

            Iterator iter = ja.iterator();

            //System.out.println(jo.names());

//            while (iter.hasNext()) {
//
//            }

        }

        catch(Exception e) {
            System.out.println(e);

        }
    }

}
