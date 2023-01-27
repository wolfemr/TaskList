import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    private int taskNumber;
    private String taskName;

    public Task(int taskNumber, String taskName) {
        this.taskNumber = taskNumber;
        this.taskName = taskName;
    }

    // setters and getters
    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskNumber(int taskCount) {
        this.taskNumber = taskCount;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    // functional methods
    public static void addTask(ArrayList<Task> taskList) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the task name: ");
        String taskName = scanner.nextLine();
        Task task = new Task(taskList.size() + 1, taskName);

        taskList.add(task);

        TaskList.getMenuSelection(taskList);
    }


    public static void deleteTask(ArrayList<Task> taskList) {

        System.out.println("Please enter the task number to delete: ");

        int taskToDelete = TaskList.checkUserInput();

        taskList.removeIf(task -> task.getTaskNumber() == taskToDelete);

        // decrement all task numbers after deleted task to keep numbering
        for (Task task: taskList) {
            if (task.getTaskNumber() > taskToDelete) {
                task.setTaskNumber((task.getTaskNumber()) - 1);
            }
        }

        TaskList.getMenuSelection(taskList);
    }


    public static void editTask(ArrayList<Task> taskList) {

        Scanner scanner = new Scanner(System.in);

        if (taskList.size() == 0) {
            System.out.println("There are no items in the to-do list.");
            TaskList.getMenuSelection(taskList);
        } else {
            TaskList.displayTaskList(taskList);
            System.out.println("Please enter the task number you wish to edit: ");
            int taskToEdit = TaskList.checkUserInput();

            System.out.println("Please enter the new task name: ");
            String newTaskName = scanner.nextLine();

            for (Task task: taskList) {
                if (task.getTaskNumber() == taskToEdit) {
                    task.setTaskName(newTaskName);
                    System.out.println("To-do list has been updated.");
                }
            }
        }

        TaskList.getMenuSelection(taskList);
    }


    @Override
    public String toString() {
        return "Task number: " + taskNumber + " Task name: " + taskName;
    }
}
