package Demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Lesson3 {
    @Test
    public void PostUser(){
        JSONObject request=new JSONObject();
        request.put("name","George");
        request.put("age",25);
        request.put("subjectId",2);

        given().
                header("content-type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when().
                post("http://localhost:3000/users").
                then().
                statusCode(201);

    }
}
