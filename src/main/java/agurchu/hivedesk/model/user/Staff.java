package agurchu.hivedesk.model.user;

public class Staff extends User{
    public Staff(){
        super("staff", "staff@gamil.com", "staff@1234", Role.ADMIN);
    }

    public Staff(String username, String email, String password){
        super(username, email, password, Role.ADMIN);
    }
}
