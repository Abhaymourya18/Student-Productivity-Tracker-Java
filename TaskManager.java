import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add task
    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    // Remove task
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Mark task as completed
    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Get all tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}