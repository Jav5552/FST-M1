package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity3 {

    Response response;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    @BeforeClass
    public void setUp(){

        requestSpec=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet").
                addHeader("Content-Type","application/json").build();

        responseSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").
                expectBody("status",equalTo("alive")).build();

    }
    @Test(priority = 1)
    public void postRequest(){
        Map<String,Object> testData1=new HashedMap<>();
        testData1.put("id",404471);
        testData1.put("name","Riley");
        testData1.put("status","alive");

        Map<String,Object> testData2=new HashedMap<>();
        testData2.put("id",404472);
        testData2.put("name","Hansel");
        testData2.put("status","alive");

        response=given().spec(requestSpec).body(testData1).when().post();
        response=given().spec(requestSpec).body(testData2).when().post();
        response.then().spec(responseSpec);


    }

    @DataProvider(name="petInformation")
    public Object[][] petInfoData(){
        Object[][] testData=new Object[][]{
                {404471, "Riley", "alive"},{404472, "Hansel", "alive"}
        };
        return testData;
    }

    @Test(dataProvider="petInformation",priority = 2)
    public void getRequest(int id,String name,String status){
        response=given().spec(requestSpec).pathParam("petId",id).when().get("/{petId}");
        System.out.println(response.getBody().asPrettyString());

        response.then().spec(responseSpec).body("name",equalTo(name));
    }
    @Test(dataProvider="petInformation",priority = 3)
    public void deleteRequest(int id,String name,String status){
    response=given().spec(requestSpec).pathParam("petId",id).when().delete("/{petId}");
    response.then().statusCode(200);

    }
}
