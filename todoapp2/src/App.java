/**
 * Created by User on 2017. 04. 08..
 */
public class App {

  public static void main(String[] args) {

    TaskList taskList = new TaskList("tasks.csv");

    taskList.removeTask(1);
    taskList.listTasks();
  }
}
