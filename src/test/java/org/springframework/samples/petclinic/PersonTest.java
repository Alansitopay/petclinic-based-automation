package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Person;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("Person Model Unit Tests")
public class PersonTest {
    @Mock
    private Person person;
    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp(){
        closeable = MockitoAnnotations.openMocks(this);
    }
    @AfterMethod
    public void tearDown () throws Exception {
        closeable.close();
    }


    @Test
    public void testPersonMock (){
        Mockito.when(person.getFirstName()).thenReturn("Roberto");
        Mockito.when(person.getLastName()).thenReturn("Gutierrez");
        Assert.assertEquals(person.getFirstName(),"Roberto");
        Assert.assertEquals(person.getLastName(),"Gutierrez");
        Mockito.verify(person).getFirstName();
        Mockito.verify(person).getLastName();
    }
    @Test
    public void testGetFirstName (){
        Person person = new Person();
        person.setFirstName("Roberto");
        Assert.assertEquals(person.getFirstName(),"Roberto");
    }
    @Test
    public void testGetLastName (){
        Person person = new Person();
        person.setLastName("Gutierrez");
        Assert.assertEquals(person.getLastName(),"Gutierrez");
    }
}
