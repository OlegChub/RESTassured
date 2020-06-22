package Demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Lesson2 {
    @Test
    public void test3() {
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael", "Lindsay", "Tobias"))
                .log().all();
    }

    @Test
    public void testPOST1() {

// или можно передать в JSONObject hashmap
        JSONObject request = new JSONObject();
        request.put("name", "Lera");
        request.put("job", "logistics");

        System.out.println(request);

        given()
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .post("https://reqres.in/api/users").
                then()
                .statusCode(201);
    }
}
