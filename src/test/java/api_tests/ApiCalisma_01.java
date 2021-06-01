package api_tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class ApiCalisma_01 {

    String endPoint;
    Response response;
    JsonPath json;


    {
        endPoint = "https://gorest.co.in/public-api/users/";
    }


    @Test
    public void statusCodeAssertion() {

        Response response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);
        response.prettyPrint();
        //   response.then().assertThat().statusCode(200);
        assertEquals(response.getStatusCode(), 200);

        json = response.jsonPath();

        int actualStatusCode = json.getInt("code");
        System.out.println("actualStatusCode = " + actualStatusCode);

    }

    @Test
    public void contentTypeCheck() {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endPoint);

        response.then().assertThat().
                statusCode(200).
                contentType("application/json");

    }

    @Test
    public void allDataCountCheck() {
        response = given().
                    accept(ContentType.JSON).
                when().
                    get(endPoint);


        response.then().assertThat().
                                    statusCode(200);
        json = response.jsonPath();

        int actualTotalData = json.getInt("meta.pagination.total");
        int expectedTotalData = 1375;

        Assert.assertEquals(actualTotalData,expectedTotalData);

    }

}
