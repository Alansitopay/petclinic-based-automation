package org.springframework.samples.petclinic.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    public void clickLink(String tabName){
        driver.findElement(By.linkText(tabName)).click();
    }

    public OwnerPage clickOwnerPage (){
        clickLink("Owners");
        return new OwnerPage(driver);
    }
}
