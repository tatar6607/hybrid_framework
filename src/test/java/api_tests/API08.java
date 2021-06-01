package api_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.Result;
import pojos.Trivia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class API08 {

    Response response;
    String endpoint = "https://opentdb.com/api.php";
    ObjectMapper objectMapper;
    RequestSpecification spec;


    @BeforeClass
    public void setUp() {
        objectMapper = new ObjectMapper();
        spec = new RequestSpecBuilder().setBaseUri(endpoint).build();
    }

    @Test
    public void TC_01() {
        response = given().
                        spec(spec).
                    when().
                        get();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getBody().asString(), "");

    }

    @Test
    public void TC_02() throws JsonProcessingException {
        spec.accept(ContentType.JSON);
        spec.queryParam("amount", "10");

        response = given().
                        spec(spec).
                    when().
                        get();

        Trivia questions = objectMapper.readValue(response.asString(), Trivia.class);

        int amount = questions.getResults().size();
        Assert.assertEquals(amount, 10);

        Set<String> cateqories = questions.getResults().
                stream().
                map(Result::getCategory).
                collect(Collectors.toSet());
        System.out.println(cateqories);

        Assert.assertTrue(cateqories.size() > 1);

        Set<String> difficulty = questions.getResults().
                stream().
                map(Result::getDifficulty).
                collect(Collectors.toSet());
//        System.out.println(difficulty);
        Assert.assertTrue(difficulty.size() > 1);

//        List<String> allType = response.jsonPath().getList("results.type");
//        Set<String> uniqueType = new HashSet<>(allType);

        Set<String> type = questions.getResults().
                                    stream().
                                    map(Result::getType).
                                    collect(Collectors.toSet());
//        System.out.println(type);
        Assert.assertTrue(type.size()>=1);
    }

    @Test
    public void TC_03() throws JsonProcessingException {
        spec.queryParams("amount", "10",
                "category", "27");

        response = given().
                        spec(spec).
                    when().
                        get();

        Trivia questions = objectMapper.readValue(response.asString(), Trivia.class);
        Set<String> category = questions.getResults().
                stream().
                map(Result::getCategory).
                collect(Collectors.toSet());
//        System.out.println("category = " + category);
        Assert.assertTrue(category.size() == 1 && category.contains("Animals"));

        Set<String> type = questions.getResults().
                stream().
                map(Result::getType).
                collect(Collectors.toSet());
//        System.out.println(type);
        Assert.assertTrue(type.size() > 1);

    }

    @Test
    public void TC_04() {
        spec.queryParams("amount", 10,
                "type", "boolean");
        response = given().
                        spec(spec).
                    when().
                        get();
//        response.prettyPrint();
        Trivia questions = response.as(Trivia.class);
        int amount = questions.getResults().size();
        Assert.assertEquals(amount, 10);

        Set<String> types = questions.getResults().stream().map(Result::getType).collect(Collectors.toSet());
        Assert.assertTrue(types.size() == 1 && types.contains("boolean"));
    }
}
