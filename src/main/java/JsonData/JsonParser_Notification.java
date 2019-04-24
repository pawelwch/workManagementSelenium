package JsonData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser_Notification {


    public static String error_PhoneInput;
    public static String setUpAccount_email_no_email;

    /**Metoda, która parsuje json'y*/
    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/main/resources/Tlumaczenia.json"));
            JSONObject jsonObject = (JSONObject) object;
            error_PhoneInput = (String) jsonObject.get("error_PhoneInput");
            setUpAccount_email_no_email = (String) jsonObject.get("koala");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}

