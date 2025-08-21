package ServicesApi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VetApiTest extends Base {

    @Test
    public void listVets() {
        given()
            .when().get("/vets")
            .then().statusCode(200);
    }

    @Test
    public void createVet() {
        String firstName = "alfonso";
        String lastName = "veterinarium";
        String body = "{\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\"}";

        given()
            .contentType(ContentType.JSON)
            .body(body)
            .when().post("/vets")
            .then().statusCode(201)
            .body("firstName", equalTo(firstName))
            .body("lastName", equalTo(lastName));
    }
}
