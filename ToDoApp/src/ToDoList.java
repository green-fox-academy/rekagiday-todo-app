import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 2017. 04. 06..
 */
public class ToDoList {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

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
      Collections.sort(lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (lines.size() == 0) {
      System.out.println("nothing to do today! :)");
    } else {
      for (int i = 0; i < lines.size(); i++) {
        if (i < 9) {
          if (lines.get(i).contains("[x]")) {
            System.out.println(ANSI_GREEN + " " + (i + 1) + " - " + lines.get(i) + ANSI_RESET);
          } else if (lines.get(i).contains("1") && lines.get(i).contains("[_]")) {
            System.out.println(ANSI_RED + " " + (i + 1) + " - " + lines.get(i) + ANSI_RESET);
          } else if (lines.get(i).contains("2") && lines.get(i).contains("[_]")) {
            System.out.println(ANSI_YELLOW + " " + (i + 1) + " - " + lines.get(i) + ANSI_RESET);
          } else {
            System.out.println(" " + (i + 1) + " - " + lines.get(i));
          }
        } else {
          System.out.println((i + 1) + " - " + lines.get(i));
        }
      }
    }
  }

  void addToDo() {
    Path filePath = Paths.get("todolist.txt");
    List<String> lines;
    if (args.length == 1 || args.length == 2 && Integer.parseInt(args[1]) < 4
        && Integer.parseInt(args[1]) > 0) {
      System.out.println("Unable to add: no task provided");
    } else {
      try {
        if (Integer.parseInt(args[1]) == 1
            || Integer.parseInt(args[1]) == 2
            || Integer.parseInt(args[1]) == 3) {
          lines = Files.readAllLines(filePath);
          lines.add(lines.size(), args[1] + " [_] " + args[2]);
          Collections.sort(lines);
          Files.write(filePath, lines);
        } else {
          lines = Files.readAllLines(filePath);
          lines.add(lines.size(), "3 [_] " + args[1]);
          Collections.sort(lines);
          Files.write(filePath, lines);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      listToDos();
    }
  }

  void removeTask() {
    Path filePath = Paths.get("todolist.txt");
    List<String> lines;
    try {
      lines = Files.readAllLines(filePath);
      if (args.length == 1) {
        System.out.println("Unable to remove: no index provided");
      } else if (Integer.parseInt(args[1]) > lines.size()) {
        System.out.println("Unable to remove: index is out of bound");
      } else {
        lines.remove(Integer.parseInt(args[1]) - 1);
        Collections.sort(lines);
        Files.write(filePath, lines);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception ex) {
      System.out.println("Unable to remove: index is not a number");
    }
    listToDos();
  }
}




