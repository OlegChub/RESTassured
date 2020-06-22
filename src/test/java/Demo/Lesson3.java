package Demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Lesson3 {
    @BeforeTest
    public void init() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void PostUser() {
        JSONObject request = new JSONObject();
        request.put("name", "George");
        request.put("age", 25);
        request.put("subjectId", 2);

        given().
                header("content-type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201);

    }

    @Test
    public void PatchUser() {
        JSONObject request = new JSONObject();
        request.put("name", "Allen");

        given().
                header("content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .patch("/users/8").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void getUsersWithSubId1() {
        given().
                param("subjectId", 1).
                get("/users").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void deleteUser() {
        when()
                .delete("/users/9").
                then().
                statusCode(200);
    }
}
