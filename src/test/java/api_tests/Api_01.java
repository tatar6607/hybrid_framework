package api_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Money;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api_01 {

    Response response;
    String endpoint = "https://api.exchangeratesapi.io/latest";
    ObjectMapper mapper = new ObjectMapper();
    Money allCurrencies;


    public Response getLatestResponse() {
        Response responseCurrency = given().
                accept(ContentType.JSON).
                when().
                get(endpoint);
        return responseCurrency;
    }

    @Test
    public void getLatest() throws JsonProcessingException {
        response = getLatestResponse();
        response.then().assertThat().statusCode(200);

        allCurrencies = mapper.readValue(response.asString(), Money.class);

        String rates = allCurrencies.getRates().toString();
        rates = rates.substring(rates.indexOf("[") + 1, rates.length() - 1).trim();


        String[] allRates = rates.split(",");

        for (String currency : allRates) {
            if (currency.toUpperCase().contains("CAD")) {
                Assert.assertTrue(currency.contains("1."));
            }
            if (currency.toUpperCase().contains("USD")) {
                Assert.assertTrue(currency.contains("1."));
            }
            if (currency.toUpperCase().contains("TRY")) {
                Assert.assertTrue(currency.contains("8."));
            }
        }

        Assert.assertEquals(allCurrencies.getBase(), "EUR");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String now = dtf.format(LocalDateTime.now());
        Assert.assertEquals(allCurrencies.getDate(), now);


    }

    @Test
    public void TC_02_JsonPath() {
        JsonPath json = getLatestResponse().jsonPath();
        Map<String, Float> allRates = json.getMap("rates");

        float euro = 1.0F;
        for (String currencyKey : allRates.keySet()) {
            float rate = allRates.get(currencyKey);

            if (currencyKey.toUpperCase().equals("GBP")) {
                Assert.assertTrue(euro > rate);
            } else {
                Assert.assertTrue(euro < rate);
            }
        }
    }

    @Test
    public void TC_02_POJO() throws JsonProcessingException, IllegalAccessException {
        response = getLatestResponse();
        allCurrencies = mapper.readValue(response.asString(), Money.class);

        Field[] fields = allCurrencies.getRates().getClass().getDeclaredFields();
        List<String> allProps = new ArrayList<>();

        for (Field field : fields) {
            if (field.getType().toString().contains("Double")) {
                String fieldName = field.getName().toUpperCase();
                allProps.add(fieldName);
            }
        }

        System.out.println("allProps = " + allProps);

        for (int i = 0; i <allProps.size() ; i++) {
            String rate2 = "allCurrencies.getRates().get" + allProps.get(i) + "()";
            System.out.println("rate = " + rate2);
        }
        
    }
}


