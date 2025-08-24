package SeleniumTests;

import ServicesApi.Base;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.selenium.pages.OwnerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Owner selenium tests")
public class OwnerPageTests extends Base {

    @Test
    public void validListOfOwners(){
        OwnerPage ownerPage = homePage.clickOwnerPage();
        ownerPage.fillForm("Alfonsico","robertico","calle123","ciudad","1234567890");
        ownerPage.clickSaveButton();
        Assert.assertFalse(ownerPage.listOwnersNames().isEmpty());
    }
    @Test
    public void deleteOwner() throws InterruptedException {
        OwnerPage ownerPage = homePage.clickOwnerPage();
        ownerPage.fillForm("Alfonsico","robertico","calle123","ciudad","1234567890");
        ownerPage.clickSaveButton();
        int sizeInicial = ownerPage.listOwnersNames().size();
        Thread.sleep(1000);
        ownerPage.clickDeleteOwnerAccept("Alfonsico");
        Thread.sleep(1000);
        int sizeFinal = ownerPage.listOwnersNames().size();
        Assert.assertTrue(sizeFinal<sizeInicial);
    }
    @Test
    public void addOwner () throws InterruptedException {
        OwnerPage ownerPage = homePage.clickOwnerPage();
        int sizeInicial = ownerPage.listOwnersNames().size();
        ownerPage.fillForm("Alfonsico","robertico","calle123","ciudad","1234567890");
        ownerPage.clickSaveButton();
        Thread.sleep(1000);
        int sizeFinal = ownerPage.listOwnersNames().size();
        Assert.assertTrue(sizeFinal>sizeInicial);
    }
    @Test
    public void editOwnerByName () throws InterruptedException {
        OwnerPage ownerPage = homePage.clickOwnerPage();
        ownerPage.clickEditOwner("George");
        ownerPage.clickCancelButton();
        ownerPage.fillForm("Alfonsico","robertico","calle123","ciudad","1234567890");
        ownerPage.clickSaveButton();
        Thread.sleep(1000);
        for(WebElement elemento : ownerPage.listOwnersNames()){
            if(elemento.getText().equals("George")){
                Assert.fail("ERROR");
            }
        }
    }
}
