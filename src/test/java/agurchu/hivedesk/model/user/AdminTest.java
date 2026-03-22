package agurchu.hivedesk.model.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    // agurchu.hivedesk.model.user.AdminTest
    @Test
    @DisplayName("default values are set correctly")
    void defaultValues() {
        Admin admin = new Admin();
        assertEquals("admin", admin.getUsername());
        assertEquals(Role.ADMIN, admin.getRole());
        assertEquals("admin@company.co.za", admin.getEmail());
        assertTrue(admin.getPassword().length() > 0);
//        assertTrue(admin.getAssignedTasks().isEmpty());
//        assertTrue(admin.getInvitedEvents().isEmpty());

    }
    @Test
    void parameterizedConstructor(){
        Admin admin = new Admin("ritmo","ritmo@gmail.com", "ritmo12345" );
        assertEquals("ritmo",admin.getUsername());
        assertEquals(Role.ADMIN, admin.getRole());
        assertEquals("ritmo@gmail.com", admin.getEmail());
        assertEquals(admin.getPassword(), "ritmo12345");

    }
    @Test
    void PasswordTooShort(){
        Admin admin = new Admin("ritmo","ritmo@gmail.com", "ritmo");
        assertTrue(admin.getPassword().length() <= 8, "password should be 8 characters long");

    }

    @Test
    void setValues(){
        Admin admin = new Admin();
        admin.setUsername("ritmo");
        admin.setEmail("ritmo@gmail.com");
        admin.setPassword("ritmo@1234");
       assertEquals("ritmo", admin.getUsername());
       assertEquals("ritmo@gmail.com", admin.getEmail());
       assertEquals(admin.getPassword(), "ritmo@1234");
    }

    @Test
    void incorrectEmail() {
        Admin admin = new Admin("ritmo", "ritmogmail.com", "Ritmo@1234");
        assertFalse(admin.getEmail().contains("@"), "Email should contain '@ symbol");
    }
    @ParameterizedTest
    @ValueSource(strings = {"ritmo", "123456789", "ritmoemail", "RITMO@1234", "Ritmo1234"})
    @DisplayName("weak passwords should be rejected")
        void passwordValidation(String password){
        Admin admin = new Admin();
        admin.setPassword(password);
        assertFalse(admin.isPasswordStrong(password), "password not corrrect");
        }



}
