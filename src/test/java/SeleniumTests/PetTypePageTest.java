package SeleniumTests;

import ServicesApi.Base;
import org.springframework.samples.petclinic.selenium.pages.PetTypes;
import org.testng.annotations.Test;

public class TestPetTypePage extends Base {

    @Test
    public void TestAddPetType() throws InterruptedException {
        PetTypes petTypes = homePage.clickPetTypes();
        Thread.sleep(1000);
        petTypes.fillForm("perro");
    }
}
