package agurchu.hivedesk.model.user;

public class AdminTest {
    // agurchu.hivedesk.model.user.AdminTest
    @Test void defaultValues() {
        Admin admin = new Admin();
        assertEquals("admin", admin.getUsername());
        assertEquals(Role.ADMIN, admin.getRole());
    }

    // agurchu.hivedesk.model.task.TaskTest
    @Test void negativeEstimateBecomesZero() {
        Task t = new Task("Test", "2025-04-20", -30, Priority.HIGH);
        assertEquals(0, t.getEstMinutes());
    }

    // agurchu.hivedesk.service.UserServiceTest
    @Test void findByUsername_caseInsensitive() {
        UserService svc = new UserService();
        svc.createUser(new Staff("Bob", "bob@company", 28));
        assertTrue(svc.findByUsername("bob").isPresent());
        assertTrue(svc.findByUsername("BOB").isPresent());
    }
}
