package org.springframework.samples.petclinic.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public PetsPage clickPetsPage(){
        clickLink("Pets");
        return new PetsPage(driver);
    }

    public VisitsPage clickVisitsPage(){
        clickLink("Visits");
        return new VisitsPage(driver);
    }

    public PetTypes clickPetTypes(){
        clickLink("Pet Types");
        return new PetTypes(driver);
    }
}
