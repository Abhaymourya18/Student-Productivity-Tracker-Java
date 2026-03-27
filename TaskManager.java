import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int streak = 0;
    private String username;

    public TaskManager(String username) {
    this.username = username;
    tasks = FileHandler.loadTasks(username);
}
    // Add task
    public void addTask(String title, String priority) {
    tasks.add(new Task(title, priority));
FileHandler.saveTasks(username, tasks);
}

    // Remove task
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
FileHandler.saveTasks(username, tasks);
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Mark task as completed
   public void markTaskCompleted(int index) {
    if (index >= 0 && index < tasks.size()) {
        if (!tasks.get(index).isCompleted()) {
            tasks.get(index).markCompleted();
streak++;
FileHandler.saveTasks(username, tasks);
}
        }
     else {
        System.out.println("Invalid index!");
    }
}

    // Get all tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public int getStreak() {
    return streak;
}
public void showStats() {
    int total = tasks.size();
    int completed = 0;

    for (Task t : tasks) {
        if (t.isCompleted()) {
            completed++;
        }
    }

    int pending = total - completed;

    double percentage = 0;
    if (total > 0) {
        percentage = (completed * 100.0) / total;
    }

    System.out.println("\n--- Productivity Stats ---");
    System.out.println("Total Tasks: " + total);
    System.out.println("Completed: " + completed);
    System.out.println("Pending: " + pending);
    System.out.println("Productivity: " + percentage + "%");
}
}