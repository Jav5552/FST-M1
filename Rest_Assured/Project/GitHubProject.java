package liveporject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProject {


    //Variables
    String sshKeyValue="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILRyuJEqB/AvNy2ZZwFbzMBkBKCB4L3eqWEVxmgFu91y";
    int sshKeyId;

    //Specifications
    RequestSpecification requestSpec=new RequestSpecBuilder().setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization","token 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").
            addHeader("Content-Type","application/json").build();


    ResponseSpecification responseSpec=new ResponseSpecBuilder().expectResponseTime(lessThan(5000L)).
            expectBody("key",equalTo(sshKeyValue)).expectBody("title",equalTo("TestAPIKey")).build();




    //Post request

    @Test(priority = 1)
    public void postRequest(){

        Map<String, Object> requestBody=new HashMap<>();
        requestBody.put("title","TestAPIKey");
        requestBody.put("key",sshKeyValue);

        Response postResponse=given().spec(requestSpec).body(requestBody).when().log().all().post();

        postResponse.then().statusCode(201);
        sshKeyId=postResponse.then().extract().path("id");
        System.out.println(sshKeyId);



    }

    @Test(priority = 2)
    public void getRequest(){

        Response response=given().spec(requestSpec).pathParam("keyId",sshKeyId).when().get("/{keyId}");
        String getResponseBody=response.getBody().asPrettyString();
        System.out.println(getResponseBody);
        response.then().statusCode(200);


    }
@Test(priority = 3)
    public void deleteRequest(){

    Response response=given().spec(requestSpec).pathParam("keyId",sshKeyId).when().delete("/{keyId}");
    response.then().statusCode(204);

}
}
