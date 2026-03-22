package agurchu.hivedesk.model.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StaffTest {

    @Test
    @DisplayName("default values are set correctly")
    void defaultValues() {
        Staff staff = new Staff();
        assertEquals("staff", staff.getUsername());
        assertEquals(Role.ADMIN, staff.getRole());
        assertEquals("staff@gamil.com", staff.getEmail());
        assertTrue(staff.getPassword().length() > 0);
//        assertTrue(admin.getAssignedTasks().isEmpty());
//        assertTrue(admin.getInvitedEvents().isEmpty());

    }
    @Test
    void parameterizedConstructor(){
        Staff staff = new Staff("ritmo","ritmo@gmail.com", "ritmo12345" );
        assertEquals("ritmo",staff.getUsername());
        assertEquals(Role.ADMIN, staff.getRole());
        assertEquals("ritmo@gmail.com", staff.getEmail());
        assertEquals(staff.getPassword(), "ritmo12345");

    }
    @Test
    void PasswordTooShort(){
        Staff staff = new Staff("ritmo","ritmo@gmail.com", "ritmo");
        assertTrue(staff.getPassword().length() <= 8, "password should be 8 characters long");

    }

    @Test
    void setValues(){
        Staff staff = new Staff();
        staff.setUsername("ritmo");
        staff.setEmail("ritmo@gmail.com");
       staff.setPassword("ritmo@1234");
        assertEquals("ritmo",staff.getUsername());
        assertEquals("ritmo@gmail.com", staff.getEmail());
        assertEquals(staff.getPassword(), "ritmo@1234");
    }

    @Test
    void incorrectEmail() {
        Staff staff = new Staff("ritmo", "ritmogmail.com", "Ritmo@1234");
        assertFalse(staff.getEmail().contains("@"), "Email should contain '@ symbol");
    }
    @ParameterizedTest
    @ValueSource(strings = {"ritmo", "123456789", "ritmoemail", "RITMO@1234", "Ritmo1234"})
    @DisplayName("weak passwords should be rejected")
    void passwordValidation(String password){
        Staff staff = new Staff();
        staff.setPassword(password);
        assertFalse(staff.isPasswordStrong(password), "password not corrrect");
    }



}


