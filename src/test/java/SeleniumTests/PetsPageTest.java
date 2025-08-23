package SeleniumTests;

import ServicesApi.Base;
import org.springframework.samples.petclinic.selenium.pages.PetsPage;
import org.testng.annotations.Test;

public class PetsPageTest extends Base {
    @Test
    public void validListPets () throws InterruptedException {
        PetsPage petsPage = homePage.clickPetsPage();
        Thread.sleep(1000);
        petsPage.fillFrom("Carlitos", 02,01,2000,"1","dog");
    }
}
