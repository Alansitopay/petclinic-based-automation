package SeleniumTests;

import ServicesApi.Base;
import org.springframework.samples.petclinic.selenium.pages.SpecialtiesPage;
import org.testng.annotations.Test;

public class SpecialtiesPageTest extends Base {
    @Test
    public void addSpecialty (){
        SpecialtiesPage specialtiesPage = homePage.clickSpecialties();

    }
}
