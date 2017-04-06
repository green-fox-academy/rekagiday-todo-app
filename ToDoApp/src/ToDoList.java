import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by User on 2017. 04. 06..
 */
public class ToDoList {

  String[] args;

  public ToDoList(String[] args) {
    this.args = args;
  }

  void printUsage() {
    Path filePath = Paths.get("usage.txt");
    List<String> lines = null;
    try {
      lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < lines.size(); i++) {
      System.out.println(lines.get(i));
    }
  }

  void listToDos() {
    Path filePath = Paths.get("todolist.txt");
    List<String> lines = null;
    try {
      lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (lines.size() == 0) {
      System.out.println("nothing to do today! :)");
    } else {
      for (int i = 0; i < lines.size(); i++) {
        System.out.println(i + 1 + ". " + lines.get(i));
      }
    }
  }

  void addToDo() {
    Path filePath = Paths.get("todolist.txt");
    List<String> lines = null;
    try {
      lines = Files.readAllLines(filePath);
      lines.add(lines.size(), args[1]);
      Files.write(filePath, lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}




