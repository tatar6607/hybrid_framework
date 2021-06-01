package api_tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

public class API06 {

    Api_03 api03;
    String endPoint;
    Response response;
    JsonPath json;


    {
        api03 = new Api_03();
        endPoint = "https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01\n";
    }


    @Test
    public void tc01() {
        Response response =  api03.getResponse(endPoint);
        response.prettyPrint();
    }
}
