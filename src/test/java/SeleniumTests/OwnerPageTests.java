package SeleniumTests;

import ServicesApi.Base;
import org.springframework.samples.petclinic.selenium.pages.OwnerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OwnerPageTests extends Base {

    @Test
    public void validListOfOwners(){
        OwnerPage ownerPage = homePage.clickOwnerPage();
        ownerPage.fillForm("Alfonsico","robertico","AAAAAA","ciudad","1234567890");
        ownerPage.clickSaveButton();
        Assert.assertFalse(ownerPage.listOwnersNames().isEmpty());
    }
}
