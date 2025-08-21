package ServicesApi;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class OwnerApiTest extends Base{
    @Test
    public void listOwners(){
        given()
            .when().get("/owners")
            .then().statusCode(200);
    }

    @Test
    public void createOwner(){
        String firstName = "Juan";
        String lastName = "Carlos";
        String telephone = "1234567890";
        String body = "{"
            + "\"firstName\":\"" + firstName + "\","
            + "\"lastName\":\""  + lastName  + "\","
            + "\"address\":\"Street 1\","
            + "\"city\":\"City\","
            + "\"telephone\":\"" + telephone + "\""
            + "}";
        given()
            .contentType(ContentType.JSON)
            .body(body)
            .when().post("/owners")
            .then().statusCode(201).body("firstName", equalTo(firstName)).body("lastName", equalTo(lastName));
    }
}
