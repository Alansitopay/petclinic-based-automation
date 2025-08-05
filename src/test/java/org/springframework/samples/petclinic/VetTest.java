package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
    @Mock
    private Vet vet;
    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }
    @Test(description = "VetNames Mock")
    @Story("Vet mock with names behavior")
    public void testVetNameMock() {
        Mockito.when(vet.getFirstName()).thenReturn("VeterinarioN");
        Mockito.when(vet.getLastName()).thenReturn("VeterinarioA");
        assertEquals(vet.getFirstName(), "VeterinarioN");
        assertEquals(vet.getLastName(), "VeterinarioA");
        Mockito.verify(vet).getFirstName();
        Mockito.verify(vet).getLastName();
    }
    @Test (description = "Vet Specialty Mock")
    @Story("Vet specialties mock behavior")
    public void testAddSpecialtyMock() {
        Vet vetSpy = Mockito.spy(new Vet());

        Specialty specialty = Mockito.mock(Specialty.class);
        Mockito.when(specialty.getName()).thenReturn("Radiology");
        vetSpy.addSpecialty(specialty);

        assertEquals(vetSpy.getNrOfSpecialties(), 1);
        assertTrue(vetSpy.getSpecialties().contains(specialty));
        Mockito.verify(vetSpy).addSpecialty(specialty);
    }



    @Test(description = "Should set and get specialty name and ammount")
    @Story("Vet setters and getters")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddSpecialty() {
        Vet vet = new Vet();
        assertEquals(vet.getNrOfSpecialties(), 0);

        Specialty specialty = new Specialty();
        specialty.setName("Dentist");
        vet.addSpecialty(specialty);

        assertEquals(vet.getNrOfSpecialties(), 1);
        assertTrue(vet.getSpecialties().contains(specialty));
    }

    @Test(description = "Should retrieve a list of specialties")
    @Story("Vet Setters and getters ")
    @Severity(SeverityLevel.MINOR)
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
