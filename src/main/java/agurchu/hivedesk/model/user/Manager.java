package agurchu.hivedesk.model.user;

public class Manager extends User{

        public Manager(){
            super("manager", "manager@gamil.com", "manager@1234", Role.ADMIN);
        }

        public Manager(String username, String email, String password){
            super(username, email, password, Role.ADMIN);
        }

    }



