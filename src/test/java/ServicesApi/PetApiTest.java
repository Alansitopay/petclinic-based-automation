package ServicesApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetApiTest extends Base{
    @Test
    public void listPets (){
        given()
            .when().get("/pets")
            .then().statusCode(200);
    }

    @Test
    public void getPetById(){
        int id = 1;
        given().get("/pets").then().statusCode(200);
        given().when().get("/pets/{id}",id)
            .then().statusCode(200)
            .body("id",equalTo(id));

    }
}
