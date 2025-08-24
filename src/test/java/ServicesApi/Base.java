package ServicesApi;

import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.selenium.pages.HomePage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.qameta.allure.Attachment;

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
        driver.findElement(By.id("login-username")).sendKeys("user");
        driver.findElement(By.id("login-password")).sendKeys("password");
        driver.findElement(By.id("login-btn")).click();
    }

    @AfterMethod
    public void attachScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
