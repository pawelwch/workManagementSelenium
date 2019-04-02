package RestAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static TestMethods.BaseMethods.*;
import static io.restassured.RestAssured.given;

public class REST_Methods {

    public static Response response;
    public static final String HOST = "http://18.196.86.213:3100";

    protected void checkStatusAndShowBody(int statusCode) {
        response.getBody().prettyPeek();
        Assert.assertEquals(response.statusCode(), statusCode);
    }


    public void signUp () {
        String phone = generatePhone();
        System.out.println(phone);
        JSONObject paramBody = new JSONObject();
        paramBody.put("phoneNumber", phone);

        response = given()
                .log()
                .params()
                .contentType(ContentType.JSON)
                .body(paramBody.toJSONString())
                .request()
                .post(HOST+"/user/signup");
        checkStatusAndShowBody(200);
    }

    public void SetUserProfileData() {
        JSONObject paramBody = new JSONObject();
        paramBody.put("fullName", generateRandomString(5));
        paramBody.put("userType", "employer");
        paramBody.put("pin", generateRandomNumber(6));
        paramBody.put("dateOfBirth", "1999-06-06");
        paramBody.put("email", generateRandomEmail());
        paramBody.put("gender", "M");
        paramBody.put("entity", "company");
        paramBody.put("height", generateRandomNumber(3));
        paramBody.put("weight", generateRandomNumber(2));
        paramBody.put("city", "Warszawa, Mazowieckie, Poland");
        paramBody.put("country", "Poland");
        paramBody.put("address", generateRandomString(12));
        paramBody.put("marketingPreference", true);

        response = given()
                .log()
                .params()
                .auth()
                .oauth2("")
                .contentType(ContentType.JSON)
                .body(paramBody.toJSONString())
                .request()
                .post(HOST+"/user/signup/profileSetup");
        checkStatusAndShowBody(200);
    }

    @Test
    void test() {
        signUp();
    }

}
