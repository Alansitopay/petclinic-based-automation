package org.springframework.samples.petclinic.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetsPage {

    private WebDriver driver;
    public PetsPage(WebDriver driver){
        this.driver=driver;
    }

    public void fillFrom (String petName, Integer birth_yyyy, Integer birth_mm, Integer birth_dd, String ownerId, String petType){
        WebElement birthDate = driver.findElement(By.cssSelector("input[type='date'][name='birthDate']"));
        LocalDate fecha = LocalDate.of(birth_yyyy, birth_mm, birth_dd);
        String valor = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        WebElement petTypeSelect = driver.findElement(By.id("pet-type-select"));
        Select select = new Select(petTypeSelect);

        driver.findElement(By.name("name")).sendKeys(petName);
        birthDate.sendKeys(valor);
        driver.findElement(By.name("ownerId")).sendKeys(ownerId);
        select.selectByValue(petType);
    }

    public void clickSaveButton(){
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void clickCancelButton(){
        driver.findElement(By.cssSelector("button[type='button']")).click();
    }

    public void clickEditPet (String petName){
        driver.findElement(By.xpath("//tr[td[text()='" + petName + "']]//button[contains(@class,'edit')]")).click();
    }
    public void clickDeletePetAccept (String petName){
        driver.findElement(By.xpath("//tr[td[text()='" + petName + "']]//button[contains(text(),'Delete')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void clickDeletePetDismiss (String petName){
        driver.findElement(By.xpath("//tr[td[text()='" + petName + "']]//button[contains(text(),'Delete')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
