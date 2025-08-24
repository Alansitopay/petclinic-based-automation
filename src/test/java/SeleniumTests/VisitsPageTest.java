package SeleniumTests;

import ServicesApi.Base;
import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.selenium.pages.VisitsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VisitsPageTest extends Base {

    /*@Test
    public void validListVisits() throws InterruptedException {
        VisitsPage visitsPage = homePage.clickVisitsPage();
        Assert.assertFalse(visitsPage.listVisits().isEmpty());
        visitsPage.fillForm(01,02,2000,"Contexto","7");
        visitsPage.clickSave();
        Assert.assertTrue(visitsPage.listVisits().containsValue("Contexto"));
    } INVALIDO */
}
