package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.model.User;
import org.testng.annotations.*;

import java.util.Set;

import static org.testng.Assert.*;

@Epic("Model")
@Feature("Role Model Unit Tests")
public class RoleTest {
    @Test
    public void testGetAndSetters(){
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        Role role = new Role();
        role.setName("Admin");
        role.setUser(user);

        assertEquals(role.getUser(),user);
        assertEquals(role.getName(),"Admin");
    }
}
