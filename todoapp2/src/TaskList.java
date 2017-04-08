import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017. 04. 08..
 */
public class TaskList {

  List<Task> taskList = new ArrayList<>();

  public TaskList() {
    Path path = Paths.get("tasks.csv");
    try {
      List<String> lines = Files.readAllLines(path);
      for (String taskData : lines) {
        String[] data = taskData.split(";");
        Task newTask = new Task(data);
        taskList.add(newTask);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void listTasks() {
    for (int i = 0; i < taskList.size(); i++) {
      System.out.println((i + 1) + ".  " + taskList.get(i).toString());
    }
  }
}
