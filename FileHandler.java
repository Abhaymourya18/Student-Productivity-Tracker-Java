import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "tasks.txt";

    // Save tasks to file
    public static void saveTasks(ArrayList<Task> tasks) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                bw.write(t.getTitle() + "," + t.getPriority() + "," + t.isCompleted());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    // Load tasks from file
    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Task t = new Task(data[0], data[1]);
                if (Boolean.parseBoolean(data[2])) {
                    t.markCompleted();
                }

                tasks.add(t);
            }
        } catch (IOException e) {
            // File may not exist first time — that's fine
        }

        return tasks;
    }
}