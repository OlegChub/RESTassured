package Demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Lesson4 {

    @DataProvider(name = "DataForPost")
    public Object[][] dataParams() {
        Object[][] data = new Object[3][3];

        data[0][0] = "Teddy";
        data[0][1] = 7;
        data[0][2] = 2;

        data[1][0] = "Ann";
        data[1][1] = 22;
        data[1][2] = 1;

        data[2][0] = "Chuck";
        data[2][1] = 100;
        data[2][2] = 1;

        return data;
    }

    @Test(dataProvider = "DataForPost")
    public void PostWithParams(String name, int age, int subjectId) {
        JSONObject request = new JSONObject();
        request.put("name", name);
        request.put("age", age);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000";
        given().
                header("content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().statusCode(201).
                log().all();
    }
    @DataProvider(name="DataForDeletion")
    public Object[] deleteList(){
        return new Object[]{
                9,10,11,12,13
        };
    }

    @Test(dataProvider = "DataForDeletion")
    public void DeleteWithParams(int index){
        baseURI = "http://localhost:3000";
        when().
                delete("/users/"+index).
                then().
                statusCode(200);

    }
}
