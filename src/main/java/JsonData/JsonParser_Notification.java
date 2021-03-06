package JsonData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser_Notification {


    public static String error_PhoneInput;
    public static String error_PhoneIsRequired;
    public static String error_ValidPhoneNumber;
    public static String error_Email;
    public static String error_SmsInput;
    public static String error_PinCode;
    public static String error_PinCodeDoesntMatch;
    public static String error_setupYourAccount;
    public static String error_FullName;
    public static String error_DateOfBirth;
    public static String error_City;
    public static String error_Address;



    /**Metoda, która parsuje json'y*/
    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/main/resources/Tlumaczenia.json"));
            JSONObject jsonObject = (JSONObject) object;
            error_PhoneIsRequired = (String) jsonObject.get("error_PhoneIsRequired");
            error_ValidPhoneNumber = (String) jsonObject.get("error_ValidPhoneNumber");
            error_SmsInput = (String) jsonObject.get("error_SmsInput");
        //    error_Email = (String) jsonObject.get("error_Email;");
            error_PinCode = (String) jsonObject.get("error_PinCode");
            error_PinCodeDoesntMatch = (String) jsonObject.get("error_PinCodeDoesntMatch");
            error_setupYourAccount = (String) jsonObject.get("error_setupYourAccount");
            error_FullName = (String) jsonObject.get("error_FullName");
            error_DateOfBirth = (String) jsonObject.get("error_DateOfBirth");
            error_City = (String) jsonObject.get("error_City");
            error_Address = (String) jsonObject.get("error_Address");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}

