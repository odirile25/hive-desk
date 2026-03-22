package agurchu.hivedesk.model.task;

import agurchu.hivedesk.model.user.User;

import java.time.LocalDate;

public class Task {
    private String id;
    private String des;
    private String title;
    private LocalDate dueDate;
    private Priority priority = Priority.LOW;
    private TaskStatus status = TaskStatus.OPEN;
    private User assignee;
    private int estimatedMinutes;


    public Task(String title, String des, LocalDate dueDate, int estimatedMinutes){
        this.title = title;
        this.des = des;
        this.dueDate = dueDate;
        this.estimatedMinutes = estimatedMinutes;
    }

    public Priority getPriority(){
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    public TaskStatus getStatus(){return status;}

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void assignedTo(User user){
        this.assignee = user;
        if (user!= null)user.addAssignedTask(this);
    }
    public User getAssignee(){return assignee;}
    public int getEstimatedMinutes(){return estimatedMinutes;}

    public void setEstimatedMinutes(int estimatedMinutes){this.estimatedMinutes = estimatedMinutes;}

    public LocalDate getDueDate() {
        return dueDate;
    }


    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;

    }


    @Override
    public String toString() {
        return "Task{" +
                "des='" + des + '\'' +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", estimatedMinutes=" + estimatedMinutes +
                ", status=" + status + ", Assigned" + assignee.getUsername() +

                '}';
    }
    }


