package agurchu.hivedesk.model.user;

import agurchu.hivedesk.model.event.Event;
import agurchu.hivedesk.model.task.Task;

import java.util.List;
import java.util.Objects;

public abstract class User {


    private String username;
 private final Role role;
 private String email;
 private String password;
 private List<Task> assignedTasks;
 private List<Event>InvitedEvents;

 protected User(String username, String email, String password, Role role ){
     this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;

 }
// protected User(Role role){
//     this.role = role;
// }

    public String getUsername(){
     return username;
    }

    public String getEmail(){
     return email;
    }
    public String getPassword(){
     return password;
    }
    public void setUsername( String username){
     this.username = username;
    }
    public void setEmail( String email){
     this.email = email;
    }


    public void setPassword( String password){
     this.password = password;
    }
    public List<Task>getAssignedTasks(){
     return assignedTasks;
    }
    public List<Event>getInvitedEvents(){
     return InvitedEvents;
    }
    public void addAssignedTask(Task task){
     assignedTasks.add(task);
    }
    public void addInvitedEvent(Event event){
     InvitedEvents.add(event);
    }

    public Role getRole() {
        return role;
    }
    public boolean canAssignedTask(){
     return false;
    }

    public boolean canCreateEvent(){
     return false;
    }
    public boolean canManageUsers(){
     return false;
    }
    public boolean canUpdateOwnTasksStatus(){
     return  false;
    }
    public boolean canViewTeam(){
     return  false;
    }
    public boolean canViewInvitedEvents(){
     return false;
    }

    public boolean  isPasswordStrong(String password){
     if (password == null|| password.length() < 0)return false;
     boolean hasUpper = false;
     boolean hasLower = false;
     boolean hasDigit = false;
     boolean hasSpecialChar = false;
     for(char c : password.toCharArray()){
         if (Character.isUpperCase(c)) hasUpper = true;
         if (Character.isLowerCase(c)) hasLower = true;
         if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;

     }
     return  hasDigit && hasLower && hasUpper & hasSpecialChar;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username) && role == user.role && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(assignedTasks, user.assignedTasks) && Objects.equals(InvitedEvents, user.InvitedEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role, email, password, assignedTasks, InvitedEvents);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", assignedTasks=" + assignedTasks +
                ", InvitedEvents=" + InvitedEvents +
                '}';
    }
}
