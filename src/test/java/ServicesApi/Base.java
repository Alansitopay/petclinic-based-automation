package ServicesApi;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class Base {
    @BeforeClass
    public void config (){
        RestAssured.baseURI = "http://localhost:9966";
        RestAssured.basePath = "/petclinic/api";
    }
}
