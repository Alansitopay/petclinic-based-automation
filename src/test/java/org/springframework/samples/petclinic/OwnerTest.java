package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("Owner Model Unit Tests")
public class OwnerTest {
    @Mock
    private Owner owner;

    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp(){
        closeable= MockitoAnnotations.openMocks(this);
    }
    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testOwnerMock(){
        Mockito.when(owner.getFirstName()).thenReturn("Jane");
        Mockito.when(owner.getLastName()).thenReturn("Perez");
        Mockito.when(owner.getAddress()).thenReturn("123 aaa");
        Mockito.when(owner.getCity()).thenReturn("Ciudad");

        Assert.assertEquals(owner.getFirstName(),"Jane");
        Assert.assertEquals(owner.getLastName(),"Perez");
        Assert.assertEquals(owner.getAddress(),"123 aaa");
        Assert.assertEquals(owner.getCity(),"Ciudad");

        Mockito.verify(owner).getFirstName();
        Mockito.verify(owner).getLastName();
        Mockito.verify(owner).getAddress();
        Mockito.verify(owner).getCity();
    }



    @Test(description = "Should set and get first name")
    @Story("Owner Getter/Setter")
    public void testSetAndGetFirstName() {
        Owner owner = new Owner();
        owner.setFirstName("Jane");
        assertEquals(owner.getFirstName(), "Jane");
    }

    @Test
    public void testSetAndGetInformation (){
        Owner owner = new Owner();
        owner.setAddress("123 aaa");
        owner.setCity("Ciudad");
        owner.setTelephone("1234567890");
        Assert.assertEquals(owner.getAddress(),"123 aaa");
        Assert.assertEquals(owner.getCity(), "Ciudad");
        Assert.assertEquals(owner.getTelephone(),"1234567890");
    }
    @Test
    public void testAddPetToOwner(){
        Owner owner = new Owner();
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Roberto");
        owner.addPet(pet);
        Assert.assertEquals(owner.getPets().size(),1);
        Assert.assertEquals(pet.getOwner(), owner);
        Assert.assertEquals(owner.getPet("Roberto"),pet);
    }

    @Test
    public void testGetPetIgnoreNew(){
        Owner owner = new Owner();
        Pet existente = new Pet();
        existente.setId(2);
        existente.setName("Roberto Viejo");
        owner.addPet(existente);

        Pet nuevo = new Pet();
        nuevo.setName("Roberto Nuevo");
        owner.addPet(nuevo);
        Assert.assertNotNull(owner.getPet("Roberto Nuevo"));
        Assert.assertEquals(owner.getPet("Roberto Viejo"),existente);
    }
}
