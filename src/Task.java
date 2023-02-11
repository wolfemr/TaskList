import java.util.ArrayList;
import java.util.Scanner;

// The Task class is designed to hold all the data for each individual task, as well as hold those task objects
// in a list
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

        Menu.getMenuSelection(listOfTasks);
    }


    public static void deleteTask(ArrayList<Task> listOfTasks) {

        System.out.println("Please enter the task number to delete: ");

        int taskToDelete = Menu.checkUserInput();

        listOfTasks.removeIf(task -> task.getTaskNumber() == taskToDelete);

        // decrement all task numbers after deleted task to keep numbering
        for (Task task: listOfTasks) {
            if (task.getTaskNumber() > taskToDelete) {
                task.setTaskNumber((task.getTaskNumber()) - 1);
            }
        }

        Menu.getMenuSelection(listOfTasks);
    }


    public static void editTask(ArrayList<Task> listOfTasks) {

        Scanner scanner = new Scanner(System.in);

        if (listOfTasks.size() == 0) {
            System.out.println("There are no items in the to-do list.");
            Menu.getMenuSelection(listOfTasks);
        } else {
            Menu.displayTaskList();
            System.out.println("\nPlease enter the task number you wish to edit: ");
            int taskToEdit = Menu.checkUserInput();

            System.out.println("Please enter the new task name: ");
            String newTaskName = scanner.nextLine();

            for (Task task: listOfTasks) {
                if (task.getTaskNumber() == taskToEdit) {
                    System.out.println("Changing task " + task.getTaskName() + " to " + newTaskName + ".");
                    task.setTaskName(newTaskName);
                    System.out.println("\nTo-do list has been updated.");
                }
            }
        }

        Menu.getMenuSelection(listOfTasks);
    }


    @Override
    public String toString() {
        return "Task number: " + taskNumber + " Task name: " + taskName;
    }
}
