package ServicesApi;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.selenium.pages.HomePage;
import org.testng.annotations.BeforeClass;

public class Base {
    protected WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void config (){
        driver = new ChromeDriver();
        driver.get("http://localhost:9966/petclinic/index.html");
        RestAssured.baseURI = "http://localhost:9966";
        RestAssured.basePath = "/petclinic/api";
        homePage = new HomePage(driver);
    }
}
