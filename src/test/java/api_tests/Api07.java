package api_tests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.Trivia;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Api07 {

    Response response;
    JsonPath json;
    String endpoint = "https://opentdb.com/api.php?amount=10&category=23&difficulty=easy&type=multiple";
    ObjectMapper objectMapper;


    @BeforeClass
    public void setUp() {
        response = given().get(endpoint);
        json = response.jsonPath();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void TC_01() {
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void TC_02() {
        List<Map<String, Object>> allResult = json.getList("results");
        int totalQuestion = allResult.size();
        Assert.assertEquals(totalQuestion, 10);

        List<String> questions = json.getList("results.question");
        questions.forEach(t -> Assert.assertFalse(t == null));
    }

    @Test
    public void TC_03() {
        List<String> correctsAnswers = json.getList("results.correct_answer");
        Assert.assertEquals(correctsAnswers.size(), 10);
        correctsAnswers.forEach(Assert::assertNotNull);

        List<Map<String, Object>> answers = json.getList("results");
        answers.forEach(t -> Assert.assertTrue(t.containsKey("correct_answer")));

        System.out.println("=====================================");
        List<List<String>> allIncorrectAnswers = json.getList("results.incorrect_answers");
        allIncorrectAnswers.forEach(t -> Assert.assertEquals(t.size(), 3));
        allIncorrectAnswers.stream().flatMap(Collection::stream).forEach(Assert::assertNotNull);

    }

    @Test
    public void TC_04_POJO() throws JsonProcessingException {
        Trivia questions = objectMapper.readValue(response.asString(), Trivia.class);
       // System.out.println(questions.getResults().stream().filter(t->t.getIncorrectAnswers().stream().));

    }
}
