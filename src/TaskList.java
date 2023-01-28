import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    public static void main(String[] args) {

        getMenuSelection(Task.getListOfTasks());

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


    public static void displayTaskList() {

        if (Task.getListOfTasks().size() == 0) {
            System.out.println("There are no items in the to-do list.");
        } else {
            for (Task task: Task.getListOfTasks()) {
                System.out.println(task);
            }
        }
    }


    public static void getMenuSelection(ArrayList<Task> taskList) {

        displayMenu();

        int selection = checkUserInput();

        switch (selection) {
            case 1 -> {
                displayTaskList();
                getMenuSelection(Task.getListOfTasks());
            }
            case 2 -> Task.addTask(Task.getListOfTasks());
            case 3 -> Task.editTask(Task.getListOfTasks());
            case 4 -> Task.deleteTask(Task.getListOfTasks());
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
