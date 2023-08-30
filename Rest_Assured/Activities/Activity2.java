package activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class Activity2 {

    String baseURI="https://petstore.swagger.io/v2/user";

    @Test(priority = 1)

    public void postRequest() throws IOException {

        FileInputStream inputFile=new FileInputStream("src/test/java/activities/userinfo.json");

        String fileData=new String(inputFile.readAllBytes());
        Response response=given().header("Content-Type","application/json").body(fileData).when().post(baseURI);

        inputFile.close();
        response.then().statusCode(200);
        response.then().body("message",equalTo("4041"));


    }

    @Test(priority = 2)
    public void getRequest() throws IOException {

        File outPutFile=new File("src/test/java/activities/outPutFile.json");

        Response response=given().header("Content-Type","application/json").pathParam("username","TestAutomation").when().get(baseURI+"/{username}");

        String responseBody=response.getBody().asPrettyString();
        outPutFile.createNewFile();
        FileWriter writerObj = new FileWriter(outPutFile.getPath());
        writerObj.write(responseBody);
        writerObj.close();
        System.out.println(responseBody);

            response.then().body("id",equalTo(4041));
            response.then().body("username",equalTo("TestAutomation"));
            response.then().body("firstName",equalTo("Test"));
            response.then().body("lastName",equalTo("Automation"));
            response.then().body("email",equalTo("testautomation@mail.com"));
            response.then().body("password",equalTo("password123"));
            response.then().body("phone",equalTo("9812763450"));




    }

    @Test(priority = 3)
    public void deleteRequest(){

        Response response=given().header("Content-Type","application/json").pathParam("username","TestAutomation").when().delete(baseURI+"/{username}");

        response.then().statusCode(200);
        response.then().body("message",equalTo("TestAutomation"));
    }
}
