package api_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojos.Money;
import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Api_02 {

    Response response;
    String endpoint = "https://api.exchangeratesapi.io/2010-01-12";
    ObjectMapper mapper = new ObjectMapper();
    Money allCurrencies;

    public Response getResponse() {
        response = given().
                accept(ContentType.JSON).
                when().
                get(endpoint);
        return response;
    }

    @Test
    public void TC_01() throws JsonProcessingException {
        getResponse().then().assertThat().statusCode(200);
        Money allCurrencies = mapper.readValue(response.asString(), Money.class);

        double lira = allCurrencies.getRates().getTRY();
        Assert.assertEquals(lira, 2.1084);

        double czk = allCurrencies.getRates().getCZK();
        Assert.assertEquals(czk, 26.258);

        double pln = allCurrencies.getRates().getPLN();
        Assert.assertEquals(pln, 4.0838);

        String base = allCurrencies.getBase();
        Assert.assertEquals(base, "EUR");
        String date = allCurrencies.getDate();
        Assert.assertEquals(date, "2010-01-12");
    }

    @Test
    public void TC_02() {
        JsonPath json = getResponse().jsonPath();
        Map<String, Double> allRates = json.getMap("rates");

        Map<String, Double> sortedMap = new LinkedHashMap<>();
        sortedMap =  allRates.entrySet().stream().
                        sorted(Map.Entry.comparingByValue()).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue,newValue)
                                -> oldValue,LinkedHashMap::new));
        System.out.println("sortedMap = " + sortedMap);

        Object [] allKeys = sortedMap.keySet().toArray();
        String thirdKey = allKeys[2].toString();
        System.out.println("thirdKey = " + thirdKey);
        Assert.assertEquals(thirdKey,"USD");


    }

    @Test
    public void TC_02_02() {
        JsonPath json = getResponse().jsonPath();
        Map<String, Double> allRates = json.getMap("rates");
        Map<String,Double> treeMapRates = new TreeMap<>(allRates);
        System.out.println("treeMapRates = " + treeMapRates);

        Map<String,Double> sortedByValueMap = new LinkedHashMap<>();
        treeMapRates.entrySet().stream().
                                sorted(Map.Entry.comparingByValue()).
                                forEachOrdered(t-> sortedByValueMap.put(t.getKey(),t.getValue()));

        System.out.println("sortedByValueMap = " + sortedByValueMap);

        List<String> allKeySet = new ArrayList<>(sortedByValueMap.keySet());
        String thirdKey = allKeySet.get(2);
        System.out.println("thirdKey = " + thirdKey);

        Assert.assertEquals(thirdKey,"USD");


    }

    @Test
    public void tekrar_TC_02() {
        JsonPath json = getResponse().jsonPath();
        Map<String,Double> allRates = json.getMap("rates");
        Map<String,Double> treeMap = new HashMap<>(allRates);

        Map<String,Double> sortedMap = new LinkedHashMap<>();

        treeMap.entrySet().stream().
                sorted(Map.Entry.comparingByValue()).
                forEachOrdered(t->sortedMap.put(t.getKey(),t.getValue()));

        System.out.println("sortedMap = " + sortedMap);

        Object [] allCurrencies = sortedMap.keySet().toArray();
        System.out.println("Arrays.toString(allCurrencies) = " + Arrays.toString(allCurrencies));

        String ucuncuParaBirimi = allCurrencies[2].toString();
        System.out.println("ucuncuParaBirimi = " + ucuncuParaBirimi);

        System.out.println("ucuncuParaBirimi degeri = " + sortedMap.get(ucuncuParaBirimi));

        Assert.assertEquals(ucuncuParaBirimi,"USD");



    }
}
