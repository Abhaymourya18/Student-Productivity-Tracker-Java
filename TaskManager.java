import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int streak = 0;

    public TaskManager() {
        tasks = new ArrayList<>();
        
    }

    // Add task
    public void addTask(String title, String priority) {
    tasks.add(new Task(title, priority));
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
        if (!tasks.get(index).isCompleted()) {
            tasks.get(index).markCompleted();
            streak++; // increase streak
        }
    } else {
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
}