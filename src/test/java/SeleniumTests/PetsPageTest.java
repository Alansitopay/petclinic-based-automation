package SeleniumTests;

import ServicesApi.Base;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.selenium.pages.PetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Pets selenium tests")
public class PetsPageTest extends Base {
    @Test
    public void validListPets () throws InterruptedException {
        PetsPage petsPage = homePage.clickPetsPage();
        Thread.sleep(1000);
        int cantInicial = petsPage.listPetsNames().size();
        petsPage.fillFrom("Carlitos", 02,01,2000,"1","dog");
        Thread.sleep(1000);
        petsPage.clickSaveButton();
        int cantFinal = petsPage.listPetsNames().size();
        Assert.assertTrue(cantInicial<cantFinal);
    }

    @Test
    public void editPet () throws InterruptedException {
        PetsPage petsPage = homePage.clickPetsPage();
        petsPage.clickEditPet("Leo");
        petsPage.clickCancelButton();
        petsPage.fillFrom("Carlitos", 02,01,2000,"1","dog");
        petsPage.clickSaveButton();
        Thread.sleep(1000);
        for(WebElement elemento : petsPage.listPetsNames()){
            if(elemento.getText().equals("Leo")){
                Assert.fail("ERROR");
            }
        }
    }
    @Test
    public void deletePet() throws InterruptedException {
        PetsPage petsPage = homePage.clickPetsPage();
        Thread.sleep(1000);
        petsPage.clickDeletePetAccept("Leo");
        Thread.sleep(1000);
        for(WebElement elemento : petsPage.listPetsNames()){
            if(elemento.getText().equals("Leo")){
                Assert.fail("ERROR");
            }
        }
    }
}
