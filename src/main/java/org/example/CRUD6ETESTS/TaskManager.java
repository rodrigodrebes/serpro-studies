package org.example.CRUD6ETESTS;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    List<Task> taskList = new ArrayList<>();

    public void addTask(String title, String description, String completed){
        Task task = new Task(title, description,completed);
        taskList.add(task);
    }
    public List<Task> getTasks(){
      taskList.forEach(System.out::println);
      return taskList;
    }

    public void removeTaskById(int id){
        taskList.removeIf(task-> task.getId() == id);
    }

    public void updateTask(int id, String title, String description, String completed) {
        for (Task t : taskList) {
            if (t.getId() == id) {
                t.setTitle(title);
                t.setDescription(description);
                t.setCompleted(completed);
            } else {
                System.out.println("Não foi possível atualizar! Task não encontrada!");
            }
        }

    }
}

