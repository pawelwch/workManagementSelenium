package JsonData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser_Notification {


    public static String error_PhoneInput;
    public static String error_Email;
    public static String error_SmsInput;
    public static String error_PinCode;

    /**Metoda, która parsuje json'y*/
    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/main/resources/Tlumaczenia.json"));
            JSONObject jsonObject = (JSONObject) object;
            error_PhoneInput = (String) jsonObject.get("error_PhoneInput");
            error_SmsInput = (String) jsonObject.get("error_SmsInput");
        //    error_Email = (String) jsonObject.get("error_Email;");
            error_PinCode = (String) jsonObject.get("error_PinCode");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}

