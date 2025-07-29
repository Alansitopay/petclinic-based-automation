package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.model.User;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("User Model Unit Tests")
public class UserTest {
    @Test
    public void testGettersYSetters(){
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.setEnabled(true);

        assertEquals(user.getUsername(), "user");
        assertEquals(user.getPassword(), "password");
        assertEquals(user.getEnabled(), Boolean.TRUE);
    }
}
