package api_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Api_05 {

    Api_03 api03;
    String endPoint;
    Response response;
    JsonPath json;


    {
        api03 = new Api_03();
        endPoint = "https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01";
    }

    @Test
    public void TC01() {
        response = api03.getResponse(endPoint);
        response.then().assertThat().statusCode(200);

        json = response.jsonPath();
        Map<String, Float> rates20180504 = json.getMap("rates.2018-05-04");

        Map<String, Float> treeMapRates = new TreeMap<>(rates20180504);
        Map<String, Float> sortedMapByValue = new LinkedHashMap<>();

        treeMapRates.entrySet().
                            stream().
                            sorted(Map.Entry.comparingByValue()).
                            forEachOrdered(t->sortedMapByValue.put(t.getKey(), t.getValue()));

        System.out.println(sortedMapByValue);

        Object [] allKeyset = sortedMapByValue.keySet().toArray();
        String actualCurreny  = allKeyset[0].toString();

        Assert.assertEquals(actualCurreny, "GBP");

        Float expectedRate=5.0963f;
        Float actualRate = rates20180504.get("TRY");

        Assert.assertEquals(actualRate, expectedRate);

        //

        float min=1.0f;
        String minKey="";
        for (String w: rates20180504.keySet()) {
            if(rates20180504.get(w) > min){
                min=rates20180504.get(w);
                minKey=w;
            }
        }
        System.out.println("En degerli para: " + minKey);
        System.out.println("En degerli para birimi degeri: " +  rates20180504.get(minKey));


    }

    @Test
    public void floatToDouble() {
        Float numF = 1.23f;
        Double numD = Double.parseDouble(numF+"");

        double numLast = numD;
        System.out.println("numF = " + numF);
        System.out.println("numD = " + numD);

    }
}
