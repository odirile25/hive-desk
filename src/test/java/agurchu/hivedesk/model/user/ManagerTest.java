package agurchu.hivedesk.model.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

        // agurchu.hivedesk.model.user.AdminTest
        @Test
        @DisplayName("default values are set correctly")
        void defaultValues() {
            Manager manager = new Manager();
            assertEquals("manager", manager.getUsername());
            assertEquals(Role.ADMIN, manager.getRole());
            assertEquals("manager@gamil.com", manager.getEmail());
            assertTrue(manager.getPassword().length() > 0);
//        assertTrue(admin.getAssignedTasks().isEmpty());
//        assertTrue(admin.getInvitedEvents().isEmpty());

        }
        @Test
        void parameterizedConstructor(){
            Manager manager = new Manager("ritmo","ritmo@gmail.com", "ritmo12345" );
            assertEquals("ritmo",manager.getUsername());
            assertEquals(Role.ADMIN, manager.getRole());
            assertEquals("ritmo@gmail.com", manager.getEmail());
            assertEquals(manager.getPassword(), "ritmo12345");

        }
        @Test
        void PasswordTooShort(){
            Manager manager = new Manager("ritmo","ritmo@gmail.com", "ritmo");
            assertTrue(manager.getPassword().length() <= 8, "password should be 8 characters long");

        }

        @Test
        void setValues(){
           Manager manager = new Manager();
            manager.setUsername("ritmo");
            manager.setEmail("ritmo@gmail.com");
            manager.setPassword("ritmo@1234");
            assertEquals("ritmo", manager.getUsername());
            assertEquals("ritmo@gmail.com", manager.getEmail());
            assertEquals(manager.getPassword(), "ritmo@1234");
        }

        @Test
        void incorrectEmail() {
            Manager manager = new Manager("ritmo", "ritmogmail.com", "Ritmo@1234");
            assertFalse(manager.getEmail().contains("@"), "Email should contain '@ symbol");
        }
        @ParameterizedTest
        @ValueSource(strings = {"ritmo", "123456789", "ritmoemail", "RITMO@1234", "Ritmo1234"})
        @DisplayName("weak passwords should be rejected")
        void passwordValidation(String password){
            Manager manager = new Manager();
            manager.setPassword(password);
            assertFalse(manager.isPasswordStrong(password), "password not corrrect");
        }



    }


