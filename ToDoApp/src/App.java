import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class App {

  public static void main(String[] args) {

    ToDoList list = new ToDoList(args);

    if (args.length == 0 || args[0].charAt(0) != '-') {
      list.printUsage();
    } else if (args[0].contains("-l")) {
      list.listToDos();
    } else if (args[0].contains("-a")) {
      list.addToDo();
    } else if (args[0].contains("-r")) {
      list.removeTask();
    }
  }
}
