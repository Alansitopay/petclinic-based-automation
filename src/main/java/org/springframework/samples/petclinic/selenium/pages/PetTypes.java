package org.springframework.samples.petclinic.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PetTypes {
    private WebDriver driver;
    private WebDriverWait wait;

    public PetTypes(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }


    public void fillForm(String name){
        driver.findElement(By.name("name")).sendKeys(name);
    }
    public void clickSaveButton(){
        driver.findElement(By.cssSelector("button[type='submit']"));
    }
    public void clickCancelButton(){
        driver.findElement(By.id("visit-form-cancel"));
    }
    public void editPetType(String id){
        driver.findElement(By.xpath("//tr[td[text()='" + id + "']]//button[contains(@class,'action-btn edit')]")).click();
    }
    public void deletePetType(String id){
        driver.findElement(By.xpath("//tr[td[text()='" + id + "']]//button[contains(@class,'action-btn')]")).click();
    }
    public void waiter(){
        By loadingOverlay = By.id("loading-overlay");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
    }
}
