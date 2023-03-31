import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList {
    private List<Task> tasks;
    private String fileName;

    public ToDoList(String fileName) {
        this.fileName = fileName;
        this.tasks = new ArrayList<>();
        readTasksFromFile();
    }

    private void readTasksFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String taskName = parts[0];
                    Date taskDate = new Date(Long.parseLong(parts[1]));
                    tasks.add(new Task(taskName, taskDate));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Failed to read tasks from file: " + e.getMessage());
        }
    }

    private void writeTasksToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Task task : tasks) {
                writer.write(task.getName() + "," + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to write tasks to file: " + e.getMessage());
        }
    }

    public void addTask(String taskName, Date taskDate) {
        Task newTask = new Task(taskName, taskDate);
        int i = 0;
        for (; i < tasks.size(); i++) {
            Task task = tasks.get(i);

        }
        tasks.add(i, newTask);
        writeTasksToFile();
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            writeTasksToFile();
        } else {
            System.out.println("Invalid task index: " + index);
        }
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println(i + ": " + task.getName() + " (due " + task.getDate() + ")");
            }
        }
    }
}