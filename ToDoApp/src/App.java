import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class App {

  public static void main(String[] args) {

    ToDoList list = new ToDoList(args);
    ToDo task = new ToDo(args);

    if (args.length == 0) {
      list.printUsage();
    } else if (args[0].charAt(0) != '-') {
      System.out.println("Unsupported argument");
      System.out.println();
      list.printUsage();
    } else if (args[0].contains("-l")) {
      list.listToDos();
    } else if (args[0].contains("-a")) {
      list.addToDo();
    } else if (args[0].contains("-r")) {
      list.removeTask();
    } else if (args[0].contains("-c")) {
      task.checkTask();
    }
  }
}
