git import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import org.json.simple.parser.*;

//Inspriation from: https://www.geeksforgeeks.org/parse-json-java/

//in order for these import statements to work I used the following linux command:
//export CLASSPATH=/path/to/json-simple.jar/file
//having an issue where I cannot run the HelloWorld object it compiles fine and everything it just will not run
//returns a java.lang.ClassNotFoundException every time

class HelloWorld {

    public static void main(String[] args) {

        try {

        catch(Exception e) {
            System.out.println(e);

        }
    }

}
