package agurchu.hivedesk.model.event;

import agurchu.hivedesk.model.task.Priority;
import agurchu.hivedesk.model.task.TaskStatus;
import agurchu.hivedesk.model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String id;
    private String des;
    private String title;
    private LocalDate date;
    private LocalDate startTime;
    private Priority priority = Priority.LOW;
    private TaskStatus status = TaskStatus.OPEN;
    private User assignee;
    private int durationInMinutes;
    private List<User>attendes = new ArrayList<>();
    private User organiser;
    private EventType eventType;
    private String location;

    public Event(String des, EventType eventType, String title, int durationInMinutes, LocalDate startTime, User organiser) {
        this.des = des;
        this.eventType = eventType;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.startTime = startTime;
        this.organiser = organiser;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public List<User> getAttendes() {
        return attendes;
    }

    public void addAttendes(User attendee) {
        if(!attendes.contains(attendee));
        this.attendes.add(attendee);
        attendee.addInvitedEvent(this);
    }

    public User getOrganiser() {
        return organiser;
    }

    public void setOrganiser(User organiser) {
        this.organiser = organiser;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", priority=" + priority +
                ", assignee=" + assignee +
                ", durationInMinutes=" + durationInMinutes +
                ", attendes=" + attendes.size() +
                ", organiser=" + organiser.getUsername() +
                ", eventType=" + eventType +
                ", location='" + location + '\'' +
                '}';
    }
}
