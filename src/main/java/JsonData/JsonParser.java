package JsonData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {

    public static String browser;
    public static String os;

    /**Metoda, która parsuje json'y*/
    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader("ConfigurationFile.json"));
            JSONObject jsonObject = (JSONObject) object;
            browser = (String) jsonObject.get("browser");
            os = (String) jsonObject.get("os");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
