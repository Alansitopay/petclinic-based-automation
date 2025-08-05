package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.model.Specialty;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("Specialty Model Unit Tests")
public class SpecialtyTest {
    @Mock
    private Specialty specialty;
    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }
    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }
    @Test(description = "Specialty Mock")
    @Story("Specialty mock behavior")
    public void testSpecialtyMock() {
        Mockito.when(specialty.getName()).thenReturn("Dentist");
        assertEquals(specialty.getName(), "Dentist");
        Mockito.verify(specialty).getName();
    }


    @Test(description = "Should set and get specialty name")
    @Story("Specialty getters and setters")
    @Severity(SeverityLevel.MINOR)
    public void testSetTypeName (){
        Specialty specialty = new Specialty();
        specialty.setName("Dentist");
        assertEquals(specialty.getName(),"Dentist");
    }
}
