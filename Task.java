public class Task {
    private String title;
    private boolean isCompleted;
    private String priority; // NEW

    public Task(String title, String priority) {
        this.title = title;
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getPriority() {
        return priority;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return title + " [" + priority + "] " + (isCompleted ? "[Done]" : "[Pending]");
    }
}