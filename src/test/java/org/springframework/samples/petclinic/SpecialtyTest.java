package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Specialty;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("Specialty Model Unit Tests")
public class SpecialtyTest {
    @Test
    public void testSetTypeName (){
        Specialty specialty = new Specialty();
        specialty.setName("Dentist");
        assertEquals(specialty.getName(),"Dentist");
    }
}
