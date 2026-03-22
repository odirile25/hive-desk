package agurchu.hivedesk.repository;

import agurchu.hivedesk.model.event.Event;
import agurchu.hivedesk.model.task.Task;
import agurchu.hivedesk.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository {
    private final List<Task>tasks = new ArrayList<>();
    private final List<Event>events = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void addTask(Task task){tasks.add(task);}
    public List<Task>getTasks(){return tasks;}

    public void addEvents(Event event){events.add(event);}
    public List<Event>getAllEvents(){return events;}
    public void addUsers(User user){users.add(user);}
}
