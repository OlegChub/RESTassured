package Demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Lesson2 {
    @Test
    public void test3(){
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]",equalTo(8))
                .body("data.first_name",hasItems("Michael","Lindsay","Tobias"))
                .log().all();
    }
    @Test
    public void testPOST1(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","Oleg");
        map.put("job","QA");

        JSONObject request=new JSONObject(map);
        System.out.println(request);
    }
}
