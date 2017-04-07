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

  public ToDo(String[] args) {
    this.args = args;
  }

  void checkTask() {
    Path filePath = Paths.get("todolist.txt");
    List<String> lines;
    try {
      lines = Files.readAllLines(filePath);
      String stuff = lines.get(Integer.parseInt(args[1]) - 1);
      String newString = stuff.replaceFirst(" ", "x");
      lines.set((Integer.parseInt(args[1]) - 1), newString);
      Files.write(filePath, lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
