package org.springframework.samples.petclinic.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OwnerPage {
    private WebDriver driver;
    public OwnerPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<WebElement> listOwnersNames(){
        List<WebElement> firstNames = driver.findElements(By.xpath("//tr/td[2]"));
        return firstNames;
    }

    public void fillForm (String firstName, String lastName, String address, String city, String telephone){
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("telephone")).sendKeys(telephone);
    }
    public void clickCancelButton(){
        driver.findElement(By.cssSelector("button[type='button']")).click();
    }
    public void clickSaveButton(){
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void clickEditOwner (String ownerName){
        driver.findElement(By.xpath("//tr[td[text()='" + ownerName + "']]//button[contains(@class,'edit')]")).click();
    }
    public void clickDeleteOwnerAccept (String ownerName){
        driver.findElement(By.xpath("//tr[td[text()='" + ownerName + "']]//button[contains(text(),'Delete')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void clickDeleteOwnerDismiss (String ownerName){
        driver.findElement(By.xpath("//tr[td[text()='" + ownerName + "']]//button[contains(text(),'Delete')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
