package BackendLogicTests;

import io.qameta.allure.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.model.User;
import org.testng.annotations.*;

import static org.testng.Assert.*;

@Epic("Model")
@Feature("Role Model Unit Tests")
public class RoleTest {
    @Mock
    private Role role;
    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }
    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test(description = "Role Mock")
    @Story("Role mock behavior")
    public void testRoleMock() {
        Mockito.when(role.getName()).thenReturn("Admin");
        assertEquals(role.getName(), "Admin");
        Mockito.verify(role).getName();
    }



    @Test(description = "Should get and set role information")
    @Story("Role Setters and getters")
    @Severity(SeverityLevel.NORMAL)
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
