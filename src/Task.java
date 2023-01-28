import java.util.ArrayList;
import java.util.Scanner;

public class Task {

    private int taskNumber;
    private String taskName;
    private static final ArrayList<Task> listOfTasks = new ArrayList<>();

    public Task(int taskNumber, String taskName) {
        this.taskNumber = taskNumber;
        this.taskName = taskName;
    }

    public static ArrayList<Task> getListOfTasks() {
        return listOfTasks;
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
    public static void addTask(ArrayList<Task> listOfTasks) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the task name: ");
        String taskName = scanner.nextLine();
        Task task = new Task(listOfTasks.size() + 1, taskName);

        listOfTasks.add(task);

        TaskList.getMenuSelection(listOfTasks);
    }


    public static void deleteTask(ArrayList<Task> listOfTasks) {

        System.out.println("Please enter the task number to delete: ");

        int taskToDelete = TaskList.checkUserInput();

        listOfTasks.removeIf(task -> task.getTaskNumber() == taskToDelete);

        // decrement all task numbers after deleted task to keep numbering
        for (Task task: listOfTasks) {
            if (task.getTaskNumber() > taskToDelete) {
                task.setTaskNumber((task.getTaskNumber()) - 1);
            }
        }

        TaskList.getMenuSelection(listOfTasks);
    }


    public static void editTask(ArrayList<Task> listOfTasks) {

        Scanner scanner = new Scanner(System.in);

        if (listOfTasks.size() == 0) {
            System.out.println("There are no items in the to-do list.");
            TaskList.getMenuSelection(listOfTasks);
        } else {
            TaskList.displayTaskList();
            System.out.println("Please enter the task number you wish to edit: ");
            int taskToEdit = TaskList.checkUserInput();

            System.out.println("Please enter the new task name: ");
            String newTaskName = scanner.nextLine();

            for (Task task: listOfTasks) {
                if (task.getTaskNumber() == taskToEdit) {
                    task.setTaskName(newTaskName);
                    System.out.println("To-do list has been updated.");
                }
            }
        }

        TaskList.getMenuSelection(listOfTasks);
    }


    @Override
    public String toString() {
        return "Task number: " + taskNumber + " Task name: " + taskName;
    }
}
