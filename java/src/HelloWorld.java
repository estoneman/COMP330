import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import org.json.simple.parser.*;

//in order for these import statements to work I used the following linux command:
//export CLASSPATH=/path/to/json-simple.jar/file
//having an issue where I cannot run the HelloWorld object it compiles fine and everything it just will not run
//returns a java.lang.ClassNotFoundException every time

class HelloWorld {

    public static void main(String[] args) {
        JSONObject jO = new JSONObject();

        try {
            // parsing file "JSONExample.json"
            //change the file location to whatever it is on your computer
            Object obj = new JSONParser().parse(new FileReader("Users/Ethan/AndroidStudioProjects/COMP330/json/sample.json"));

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            //just testing to see if it will get our last names from sample.json
            String lastName1 = (String) jo.get("lastName1");
            String lastName2 = (String) jo.get("lastName2");

            System.out.println(lastName1);
            System.out.println(lastName2);
        }

        catch(Exception e) {
            System.out.println(e);

        }
    }

}
