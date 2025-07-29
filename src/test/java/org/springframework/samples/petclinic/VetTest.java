package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

@Epic("Model")
@Feature("Vet Model Unit Tests")
public class VetTest {
    @Test
    public void testAddSpecialty() {
        Vet vet = new Vet();
        assertEquals(vet.getNrOfSpecialties(), 0);

        Specialty specialty = new Specialty();
        specialty.setName("Dentistry");
        vet.addSpecialty(specialty);

        assertEquals(vet.getNrOfSpecialties(), 1);
        assertTrue(vet.getSpecialties().contains(specialty));
    }

    @Test
    public void testSpecialtyList(){
        Vet vet = new Vet();

        Specialty s1 = new Specialty();
        s1.setName("Especialidad3");
        Specialty s2 = new Specialty();
        s2.setName("Especialidad2");
        Specialty s3 = new Specialty();
        s3.setName("Especialidad1");

        vet.addSpecialty(s1);
        vet.addSpecialty(s2);
        vet.addSpecialty(s3);

        List<String> names = new ArrayList<>();
        for (Specialty s : vet.getSpecialties()) {
            names.add(s.getName());
        }
        assertEquals(names, Arrays.asList("Especialidad1", "Especialidad2", "Especialidad3"));
    }
}
