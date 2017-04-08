/**
 * Created by User on 2017. 04. 08..
 */
public class Task {

  String title;
  boolean done;
  int priority;


  public Task(String[] taskData) {
    this.priority = Integer.parseInt(taskData[0]);
    this.done = Boolean.parseBoolean(taskData[1]);
    this.title = taskData[2];

  }

  public String getTitle() {
    return title;
  }

  public boolean isDone() {
    return done;
  }

  public int getPriority() {
    return priority;
  }

  @Override
  public String toString() {
    String checkMark = done ? "x" : " ";
    return priority + " [" + checkMark + "] " + title;
  }
}
