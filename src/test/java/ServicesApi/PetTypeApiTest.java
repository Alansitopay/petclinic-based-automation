package ServicesApi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetTypeApiTest extends Base{
    @Test
    public void listPetTypes (){
        given()
            .when().get("/pettypes")
            .then().statusCode(200);
    }
    @Test
    public void createPetType (){
        String name = "dinosaurio";
        String body = "{\"name\":\""+name+"\"}";
        given()
            .contentType(ContentType.JSON)
            .body(body)
            .when().post("/pettypes")
            .then().statusCode(201)
            .body("name",equalTo(name));
    }
}
