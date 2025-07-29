package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.security.core.parameters.P;
import org.testng.annotations.*;

import java.time.LocalDate;

import static org.testng.Assert.*;

@Epic("Model")
@Feature("Pet Model Unit Tests")
public class PetTest {
    @Test
    public void testSetGetBirthDate() {
        Pet pet = new Pet();
        LocalDate date = LocalDate.of(2020, 5, 1);
        pet.setBirthDate(date);
        assertEquals(pet.getBirthDate(), date);
    }
    @Test
    public void testSetGetType(){
        Pet pet = new Pet();
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);
        assertEquals(pet.getType(), type);
    }
    @Test
    public void testSetGetOwner(){
        Pet pet = new Pet();
        org.springframework.samples.petclinic.model.Owner owner = new Owner();
        owner.setFirstName("Carlitos");
        pet.setOwner(owner);
        assertEquals(pet.getOwner().getFirstName(),"Carlitos");
    }
}
