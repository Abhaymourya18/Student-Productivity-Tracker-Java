import javax.swing.*;
import java.awt.*;

public class TaskGUI {

    private TaskManager manager;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(listModel);

    public TaskGUI(String username) {

        manager = new TaskManager(username);

        JFrame frame = new JFrame("Productivity Tracker - " + username);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10,10));
        mainPanel.setBackground(new Color(240,240,240));

        // 🔹 Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(200, 220, 240));

        JTextField taskField = new JTextField(15);
        String[] priorities = {"High", "Medium", "Low"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);

        JButton addButton = new JButton("Add Task");
        addButton.setBackground(new Color(70,130,180));
        addButton.setForeground(Color.WHITE);

        topPanel.add(taskField);
        topPanel.add(priorityBox);
        topPanel.add(addButton);

        // 🔹 Center List
        taskList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(taskList);

        // 🔹 Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(220,220,220));

        JButton doneButton = new JButton("Mark Done");
        JButton deleteButton = new JButton("Delete");
        JButton statsButton = new JButton("Stats");
        JButton streakButton = new JButton("Streak");

        bottomPanel.add(doneButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(statsButton);
        bottomPanel.add(streakButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        // Load tasks
        for (Task t : manager.getTasks()) {
            listModel.addElement(t.toString());
        }

        // Add Task
        addButton.addActionListener(e -> {
            String text = taskField.getText();
            String priority = (String) priorityBox.getSelectedItem();

            if (!text.isEmpty()) {
                manager.addTask(text, priority);
                listModel.addElement(text + " [" + priority + "] [Pending]");
                taskField.setText("");
            }
        });

        // Done
        doneButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                manager.markTaskCompleted(index);
                listModel.set(index, manager.getTasks().get(index).toString());
            }
        });

        // Delete
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                manager.removeTask(index);
                listModel.remove(index);
            }
        });

        // Stats
        statsButton.addActionListener(e -> {
            int total = manager.getTasks().size();
            int completed = 0;

            for (Task t : manager.getTasks()) {
                if (t.isCompleted()) completed++;
            }

            JOptionPane.showMessageDialog(frame,
                    "Total: " + total +
                    "\nCompleted: " + completed +
                    "\nPending: " + (total - completed) +
                    "\nProductivity: " + (total > 0 ? (completed * 100 / total) : 0) + "%");
        });

        // Streak
        streakButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Current Streak: " + manager.getStreak());
        });

        frame.setVisible(true);
    }
}