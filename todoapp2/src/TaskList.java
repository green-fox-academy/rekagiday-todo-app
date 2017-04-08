import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017. 04. 08..
 */
public class TaskList {

  List<Task> tasks = new ArrayList<>();
  Path path;

  public TaskList(String taskPath) {
    this.path = Paths.get(taskPath);
    try {
      List<String> lines = Files.readAllLines(path);
      for (String taskData : lines) {
        String[] data = taskData.split(";");
        Task newTask = new Task(data);
        tasks.add(newTask);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void listTasks() {
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + ".  " + tasks.get(i).toString());
    }
  }

  public void addTask(int prio, String title) {
    Task newTask = new Task(prio, title);
    try {
      Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
      Files.write(path, newTask.toCsvFormat().getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void removeTask(int index) {
    try {
      tasks.remove(index);
      List<String> lines = new ArrayList<>();
      for (Task task : tasks) {
        lines.add(task.toCsvFormat());
      }
      Files.write(path, lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


