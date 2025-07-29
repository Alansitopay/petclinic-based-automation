package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.Person;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("Person Model Unit Tests")
public class PersonTest {

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
