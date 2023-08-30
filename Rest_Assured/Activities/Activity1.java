package activities;

import io.restassured.response.Response;
import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {

    String baseURI="https://petstore.swagger.io/v2/pet";

    @Test(priority = 1)
    public void postRequest(){

        Map<String,Object> reqBody=new HashedMap<>();
        reqBody.put("id",404471);
        reqBody.put("name","Goofy");
        reqBody.put("status","alive");
        Response response=given().header("Content-Type","application/json").body(reqBody).when().post(baseURI);

        //Assertion

        response.then().body("id",equalTo(404471));
        response.then().body("name",equalTo("Goofy"));
        response.then().body("status",equalTo("alive"));

    }

    @Test(priority = 2)
    public  void getRequest(){
    Response response=given().header("Content-Type","application/json").when().pathParam("petId",404471).get(baseURI+"/{petId}");
        //Assertion

        response.then().body("id",equalTo(404471));
        response.then().body("name",equalTo("Goofy"));
        response.then().body("status",equalTo("alive"));


    }
    @Test(priority = 3)

    public void deleteRequest(){

        Response response=given().header("Content-Type","application/json").when().pathParam("petId",404471).delete(baseURI+"/{petId}");

        //Assertion
        response.then().statusCode(200);
        response.then().body("message",equalTo("404471"));
    }

}
