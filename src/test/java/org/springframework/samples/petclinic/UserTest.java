package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.model.User;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Model")
@Feature("User Model Unit Tests")
public class UserTest {
    @Mock
    private User user;

    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }
    @Test(description = "User Mock")
    @Story("User mock behavior")
    public void testUserMock() {
        Mockito.when(user.getUsername()).thenReturn("user");
        Mockito.when(user.getPassword()).thenReturn("password");
        assertEquals(user.getUsername(), "user");
        assertEquals(user.getPassword(), "password");
        Mockito.verify(user).getUsername();
        Mockito.verify(user).getPassword();
    }



    @Test(description = "Should set and get User information")
    @Story("Getters and setters of User")
    @Severity(SeverityLevel.CRITICAL)
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
