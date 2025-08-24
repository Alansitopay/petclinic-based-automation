package org.springframework.samples.petclinic.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SpecialtiesPage {
    private WebDriver driver;

    public SpecialtiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadCSVfile (){
        Path ruta = Paths.get("src/specialties.csv").toAbsolutePath();
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(ruta.toString());
    }
    public void fillForm(String name){
        driver.findElement(By.name("name")).sendKeys(name);
    }
    public void clickSaveButton (){
        driver.findElement(By.className("button-primary")).click();
    }
    public void clickEditButton (String specialtyName){
        driver.findElement(By.xpath("//tr[td[text()='" + specialtyName + "']]//button[contains(@class,'edit')]")).click();
    }
    public void clickDeleteButton (String specialtyName){
        driver.findElement(By.xpath("//tr[td[text()='" + specialtyName + "']]//button[contains(text(),'Delete')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
