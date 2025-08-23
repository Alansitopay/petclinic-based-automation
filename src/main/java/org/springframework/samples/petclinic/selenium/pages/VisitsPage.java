package org.springframework.samples.petclinic.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VisitsPage {
    private WebDriver driver;

    public VisitsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm (Integer visit_mm, Integer visit_dd, Integer visit_yyyy, String context, String petId){
        WebElement date = driver.findElement(By.cssSelector("input[type='date'][name='date']"));
        LocalDate fecha = LocalDate.of(visit_yyyy, visit_mm, visit_dd);
        String valor = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        date.sendKeys(valor);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("body[contenteditable='true']")).sendKeys(context);
        driver.switchTo().defaultContent();
        driver.findElement(By.name("petId")).sendKeys(petId);
    }
    public Map<String,String> listVisits (){
        List<WebElement> columnas = driver.findElements(By.xpath("//table[.//th[text()='Date'] and .//th[text()='Description']]//tbody/tr"));
        Map<String, String> visits = new LinkedHashMap<>();
        for (WebElement e : columnas) {
            String date = e.findElement(By.xpath("./td[1]")).getText();
            String desc = e.findElement(By.xpath("./td[2]")).getText();
            visits.put(date, desc);
        }
        return visits;
    }

    public void clickEditVisit(String id){
        driver.findElement(By.xpath("//tr[td[text()='" + id + "']]//button[contains(@class,'action-btn edit')]")).click();
    }
    public void clicDeleteVisit(String id){
        driver.findElement(By.xpath("//tr[td[text()='" + id + "']]//button[contains(@class,'action-btn')]")).click();
    }
    public void clickSave(){
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
    public void clickCancel(){
        driver.findElement(By.id("visit-form-cancel"));
    }

}
