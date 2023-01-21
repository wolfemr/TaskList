import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    public static void main(String[] args) {

        ArrayList<Task> taskList = new ArrayList<>(); // list to hold task objects during run time

        getMenuSelection(taskList);
    }


    public static int checkUserInput() {

        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            try {
                String userInput = scanner.nextLine();
                input = Integer.parseInt(userInput);
                if (input >= 1 && input <= 5) {
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        return input;
    }


    public static void displayMenu() {
        System.out.println("\n---===| To Do List |===---");
        System.out.println("1. View To-Do list");
        System.out.println("2. Add a new task");
        System.out.println("3. Edit a task");
        System.out.println("4. Delete a task");
        System.out.println("5. Exit");
        System.out.println("\nPlease make a selection: ");
    }


    public static void displayTaskList(ArrayList<Task> taskList) {

        if (taskList.size() == 0) {
            System.out.println("There are no items in the to-do list.");
        } else {
            for (Task task: taskList) {
                System.out.println(task);
            }
        }

        getMenuSelection(taskList);
    }


    public static void getMenuSelection(ArrayList<Task> taskList) {

        displayMenu();

        int selection = checkUserInput();

        switch (selection) {
            case 1 -> displayTaskList(taskList);
            case 2 -> Task.addTask(taskList);
            case 3 -> System.out.println(selection);
            case 4 -> Task.deleteTask(taskList);
            case 5 -> System.out.println("Thank you for using the program!");
            default -> {
                break;
            }
        }
    }

    // potential solution to clear screen during menu use
    /*
    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }*/
}
