package ServicesApi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VisitApiTest extends Base {

    @Test
    public void listVisits() {
        given()
            .when().get("/visits")
            .then().statusCode(200);
    }

    @Test
    public void createVisit() {
        String body = "{\"date\":\"2024-01-01\",\"description\":\"revision\",\"petId\": 1 }";

        given()
            .contentType(ContentType.JSON)
            .body(body)
            .when().post("/visits")
            .then().statusCode(201)
            .body("description", equalTo("revision"))
            .body("petId", equalTo(1));
    }
}
