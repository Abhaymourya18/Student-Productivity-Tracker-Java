import javax.swing.*;
import java.awt.*;

public class TaskGUI {
    private TaskManager manager = new TaskManager();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(listModel);

    public TaskGUI() {
        JFrame frame = new JFrame("Productivity Tracker");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField taskField = new JTextField(15);

        String[] priorities = {"High", "Medium", "Low"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);

        JButton addButton = new JButton("Add");
        JButton completeButton = new JButton("Done");
        JButton deleteButton = new JButton("Delete");
        JButton statsButton = new JButton("Stats");

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.add(taskField);
        topPanel.add(priorityBox);
        topPanel.add(addButton);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(completeButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(statsButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Load existing tasks
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

        // Mark Done
        completeButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                manager.markTaskCompleted(index);
                listModel.set(index, manager.getTasks().get(index).toString());
            }
        });

        // Delete Task
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                manager.removeTask(index);
                listModel.remove(index);
            }
        });

        // Show Stats
        statsButton.addActionListener(e -> {
            manager.showStats();
        });

        frame.setVisible(true);
    }
}