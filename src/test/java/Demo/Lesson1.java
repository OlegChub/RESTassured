package Demo;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Lesson1 {
    @Test
    public void Test1(){
        Response response= get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getBody().asString());
        System.out.println(response.getSessionId());
        System.out.println(response.getHeader("content-type"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void Test2(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
                .body("data.id[0]",equalTo(7));
    }
}
