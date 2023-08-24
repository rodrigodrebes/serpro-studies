package org.example.CRUD6ETESTS.tests;

import org.example.CRUD6ETESTS.TaskManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {

    private TaskManager tm;
    @Before
    public void setUp() {
        tm = new TaskManager();
        tm.addTask("Mercado", "compras", "Sim");

    }

    @Test
    public void deveAdicionarTask() {

        Assert.assertFalse(tm.getTasks().isEmpty());
    }

    @Test
    public void deveRemoverTask() {

        int taskId = tm.getTasks().get(0).getId();
        tm.removeTaskById(taskId);


        Assert.assertTrue(tm.getTasks().isEmpty());
    }

    @Test
    public void deveRetornarTasks(){
      tm.getTasks();
      Assert.assertFalse(tm.getTasks().isEmpty());

    }

    @Test
    public void deveAtualizarTask(){
        tm.updateTask(tm.getTasks().get(0).getId(), "Petshop", "Areia", "N");
        Assert.assertEquals(tm.getTasks().get(0).getTitle(), "Petshop");
    }


}
