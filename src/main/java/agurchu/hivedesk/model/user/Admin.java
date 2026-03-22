package agurchu.hivedesk.model.user;

public class Admin extends User{


    public Admin(){
        super("admin", "admin@company.co.za", "Admin@123", Role.ADMIN);
    }

    public Admin(String username, String email, String password){
        super(username, email, password, Role.ADMIN);
    }

}
