import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreateQuiz {

    public void writeToFile(FileWriter fileWriter, JSONObject jsonObject) {
        try {
            fileWriter.write(jsonObject.toJSONString());

            fileWriter.flush();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {

    }

}