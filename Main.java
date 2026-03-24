import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    manager.addTask(task);
                    break;

                case 2:
                    System.out.println("\nTasks:");
                    for (int i = 0; i < manager.getTasks().size(); i++) {
                        System.out.println(i + ". " + manager.getTasks().get(i));
                    }
                    break;

                case 3:
                    System.out.print("Enter task index to mark complete: ");
                    int index = sc.nextInt();
                    manager.markTaskCompleted(index);
                    break;

                case 4:
                    System.out.print("Enter task index to delete: ");
                    int delIndex = sc.nextInt();
                    manager.removeTask(delIndex);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
