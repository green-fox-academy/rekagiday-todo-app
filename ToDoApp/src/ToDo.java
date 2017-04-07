import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by User on 2017. 04. 06..
 */
public class ToDo {
  String[] args;
  ToDoList list = new ToDoList(args);


  public ToDo(String[] args) {
    this.args = args;
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";


  void checkTask() {
    Path filePath = Paths.get("todolist.txt");
    List<String> lines;
    try {
      lines = Files.readAllLines(filePath);
      String stuff = lines.get(Integer.parseInt(args[1]) - 1);
      String newString = stuff.replaceFirst("_", "x");
      lines.set((Integer.parseInt(args[1]) - 1), newString);
      Files.write(filePath, lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
    list.listToDos();
  }
}
