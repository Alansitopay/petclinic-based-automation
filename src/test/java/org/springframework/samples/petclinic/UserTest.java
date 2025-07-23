package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.model.User;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("User Model Unit Tests")
public class UserTest {
    @Test(description = "Should set and get username")
    @Story("User Getter/Setter")
    public void testSetAndGetUsername() {
        User user = new User();
        user.setUsername("bob");
        assertEquals(user.getUsername(), "bob");
    }
} 