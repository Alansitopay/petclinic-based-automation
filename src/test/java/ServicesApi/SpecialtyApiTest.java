package ServicesApi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SpecialtyApiTest extends Base {

    @Test
    public void listSpecialties() {
        given()
            .when().get("/specialties")
            .then().statusCode(200);
    }

    @Test
    public void createSpecialty() {
        String name = "cirujano";
        String body = "{\"name\":\"" + name + "\"}";

        given()
            .contentType(ContentType.JSON)
            .body(body)
            .when().post("/specialties")
            .then().statusCode(201)
            .body("name", equalTo(name));
    }
}
