package org.example.CRUD6ETESTS;

public class Task {

    private static int nextId=1;
    private int id;
    private String title;
    private String description;
    private String completed;

    public Task(){
        this.id=nextId++;
    }

    public Task(String title, String description, String completed) {
        this();
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
