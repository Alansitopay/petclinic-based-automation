package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.PetType;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("PetType Model Unit Tests")
public class PetTypeTest {
    @Mock
    private PetType petType;

    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }
    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test(description = "Pet Type Mock")
    @Story("PetType Mock Behavior")
    public void testPetTypeMock() {
        Mockito.when(petType.getName()).thenReturn("gato");
        assertEquals(petType.getName(), "gato");
        Mockito.verify(petType).getName();
    }



    @Test(description = "Should set and get the petType name")
    @Story("Setters and Getters of PetType")
    @Severity(SeverityLevel.NORMAL)
    public void testSetTypeName (){
        PetType type = new PetType();
        type.setName("gato");
        assertEquals(type.getName(),"gato");
    }
}
