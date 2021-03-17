package api_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Money;

public class Api_04 {

    Api_03 api03;
    String endPoint ;
    Response response;
    ObjectMapper mapper;

    {
        api03 = new Api_03();
        endPoint = "https://api.exchangeratesapi.io/latest?symbols=USD,GBP";
        mapper = new ObjectMapper();
    }

    @Test
    public void TC_01() throws JsonProcessingException {
        response = api03.getResponse(endPoint);
        response.then().assertThat().statusCode(200);

        Money money = mapper.readValue(response.asString(), Money.class);
        double usdCurrent = money.getRates().getUSD();
        double gbpCurrent = money.getRates().getGBP();

        Assert.assertTrue(usdCurrent > 1.19);
        Assert.assertTrue(gbpCurrent > 0.8);

        String baseCurrency = money.getBase();
        Assert.assertEquals("USD", baseCurrency);

    }

    @Test
    public void tC_01_With_JsonPath() {
        response = api03.getResponse(endPoint);
        response.then().assertThat().statusCode(200);

        JsonPath json = response.jsonPath();
        double usdCurrent = json.getDouble("rates.USD");
        double gbpCurrent = json.getDouble("rates.GBP");

        Assert.assertTrue(usdCurrent > 1.19);
        Assert.assertTrue(gbpCurrent > 0.8);

        String baseCurrency = json.getString("base");
        Assert.assertNotEquals("USD", baseCurrency);

    }
}
