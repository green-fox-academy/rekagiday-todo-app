import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class App {

  public static void main(String[] args) {

    if (args.equals("")) {
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
    } else if (args.toString().contains("l")) {
      Path filePath = Paths.get("todolist.txt");
      List<String> lines = null;
      try {
        lines = Files.readAllLines(filePath);
      } catch (IOException e) {
        e.printStackTrace();
      }
      for (int i = 0; i < lines.size(); i++) {
        System.out.println(i+1 + ". " + lines.get(i));
      }
    }
  }
}
