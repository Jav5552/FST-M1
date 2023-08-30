package liveporject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.provider.junit.State;
import org.apache.commons.collections4.map.HashedMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    //Declare headers
    Map<String,String> headers=new HashedMap<>();

    //Create the pact
    @Pact(consumer = "UserConsumer",provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        // Headers
        headers.put("Content-Type","application/json");
        //Request and response body

        DslPart requestResponseBody=new PactDslJsonBody().

                numberType("id",123).
                stringType("firstName","Test").
                stringType("lastName","Auto").
                stringType("email","automation@test.com");

        //Generate Contract
        return builder.given("POST Request").
                uponReceiving("request to create a user").
                    method("POST").
                    path("/api/users").
                    headers(headers).
                    body(requestResponseBody).
                willRespondWith().status(201).
                body(requestResponseBody).toPact();
    }
    //Test with mock provider
    @Test
    @PactTestFor(providerName = "UserProvider",port = "8282")
    public void consumerTest(){
        //Request body
        Map<String,Object> reqBody=new HashedMap<>();
        reqBody.put("id",123);
        reqBody.put("firstName","Test");
        reqBody.put("lastName","Auto");
        reqBody.put("email","automation@test.com");


        //Send body
        given().headers(headers).body(reqBody).when().post("http://localhost:8282/api/users").
                then().statusCode(201).body("firstName",equalTo("Test")).log().all();
    }


}
