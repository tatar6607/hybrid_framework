package api_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.Money;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.*;

public class Api_03 {

    String endPoint = "https://api.exchangeratesapi.io/latest?base=USD";
    Response response;
    ObjectMapper mapper;
    SoftAssert softAssert;

    public Response getResponse(String url) {
        response = given().accept(ContentType.JSON).get(url);
        return response;
    }

    @Test
    public void test() throws JsonProcessingException {
        response = getResponse(endPoint);
        response.then().assertThat().statusCode(200);

        mapper = new ObjectMapper();
        softAssert = new SoftAssert();

        Money money = mapper.readValue(response.asString(),Money.class);
        System.out.println("getEUR() = " + money.getRates().getEUR());
        System.out.println("getTRY() = " + money.getRates().getTRY());
        System.out.println("getRUB() = " + money.getRates().getRUB());

        softAssert.assertEquals(money.getRates().getEUR(), "0.81799591");
        softAssert.assertEquals(money.getRates().getTRY(), "7.2265030675");
        softAssert.assertEquals(money.getRates().getRUB(), "73.9074846626");

        softAssert.assertEquals(money.getBase(),"USD");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String now = dtf.format(LocalDateTime.now());

        softAssert.assertEquals(money.getDate(),now);

        softAssert.assertAll();

    }
}
