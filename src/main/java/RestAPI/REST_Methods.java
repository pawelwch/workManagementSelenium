package RestAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static TestMethods.BaseMethods.*;
import static TestMethods.BaseMethods.generateRandomString;
import static io.restassured.RestAssured.given;

public class REST_Methods {

    public enum DataEnum { employer, contractor, labourer}

    public static Response response;
    public static final String HOST = "http://18.196.86.213:3100";
    public static String phone = generatePhone();
    public static String email = generateRandomEmail();
    public static String pin = "123123";

    /** Metoda sprawdza status odpowiedzi metody API oraz pokazuje ciało responsu.
     * @param statusCode -oczekiwany przez nas kod odpowiedzi.*/
    protected static void checkStatusAndShowBody(int statusCode) {
        response.getBody().prettyPeek();
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    /**Metoda strzela do API i tworzy usera. W parametrach podajemy jedynie jaki typ konta ma być stworzony. Reszta parametrow tworzona jest ze staticów
     * @see #phone,#email,#pin
     * @param userType - wpisujemy typ konta. Można wybrać tylko te, które są w pliku enum
     * @see TestMethods.DataEnum */
    public static void setUpUser(DataEnum userType) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *SETUP_NEW_USER * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * " );
        JSONObject paramBody = new JSONObject();
        paramBody.put("phoneNumber", phone);
        paramBody.put("userType", userType.toString());
        paramBody.put("fullName", generateRandomString(7));
        paramBody.put("pin",pin);

        System.out.println("PHONE: " + phone+"\nEMAIL: " + email + "\nPIN: " + pin );
        response = given()
                .log()
                .params()
                .contentType(ContentType.JSON)
                .body(paramBody.toJSONString())
                .request()
                .post(HOST+"/createUser");
        checkStatusAndShowBody(200);
        System.out.println("KOONIEC");
    }


    /**Test, który sprawdza działanie metody setUpUser() */
    @Test
    void test() {
        setUpUser(DataEnum.labourer);
    }

}
