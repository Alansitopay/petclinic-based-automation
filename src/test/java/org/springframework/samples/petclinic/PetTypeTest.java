package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.PetType;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("PetType Model Unit Tests")
public class PetTypeTest {
    @Test
    public void testSetTypeName (){
        PetType type = new PetType();
        type.setName("gato");
        assertEquals(type.getName(),"gato");
    }
}
