import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- To-Do List ---");
            if (tasks.isEmpty()) {
                System.out.println("No tasks yet.");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            }

            System.out.println("\nOptions Menu:");
            System.out.println("==========================");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Exit program");
            System.out.println("==========================");
            System.out.print("Enter your option (1-4): ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    // Add task
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    String date;
                    while (true) {
                        System.out.print("Enter the due date of task (mm/dd/yyyy): ");
                        date = scanner.nextLine();
                        if (InputValidator.isValidDate(date)) {
                            break;
                        } else {
                        System.out.println("Invalid date! Please enter a valid date in mm/dd/yyyy format.");
                        }
                    }

                    String priority;
                    while (true) {
                        System.out.print("Enter priority (LOW, MED, HIGH): ");
                        priority = scanner.nextLine().trim().toUpperCase();
                        if (priority.equals("LOW") || priority.equals("MED") || priority.equals("HIGH")) {
                            break;
                        }
                        System.out.println("Invalid priority. Please type 'LOW', 'MED', or 'HIGH'.");
                    }

                    tasks.add(new Task(description, priority, date));

                    // Sort by priority: HIGH > MED > LOW
                    tasks.sort(new Comparator<Task>() {
                        public int compare(Task t1, Task t2) {
                            return getPriorityValue(t2.priority) - getPriorityValue(t1.priority);
                        }

                        private int getPriorityValue(String priority) {
                            switch (priority) {
                                case "HIGH": return 3;
                                case "MED": return 2;
                                case "LOW": return 1;
                                default: return 0;
                            }
                        }
                    });
                    System.out.println("Task added successfully!");
                    break;

                case "2":
                    // Remove task
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                        break;
                    }

                    while (true) {
                        System.out.print("Enter task number to remove (0 to cancel): ");
                        try {
                            int index = Integer.parseInt(scanner.nextLine());
                            if (index == 0) {
                                System.out.println("Canceling remove.");
                                break;
                            }
                            if (index >= 1 && index <= tasks.size()) {
                                tasks.remove(index - 1);
                                System.out.println("Task removed.");
                                break;
                            } else {
                                System.out.println("Invalid task number. Try again.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }
                    break;

                case "3":
                    // Mark task as completed
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to mark as completed.");
                        break;
                    }

                    while (true) {
                        System.out.print("Enter task number to mark as completed (0 to cancel): ");
                        try {
                            int index = Integer.parseInt(scanner.nextLine());
                            if (index == 0) {
                                System.out.println("Canceling mark completed.");
                                break;
                            }
                            if (index >= 1 && index <= tasks.size()) {
                                Task task = tasks.get(index - 1);
                                if (!task.isCompleted()) {
                                    task.markCompleted();
                                    System.out.println("Task marked as completed.");
                                } else {
                                    System.out.println("Task is already completed.");
                                }
                                break;
                            } else {
                                System.out.println("Invalid task number. Try again.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }
                    break;

                case "4":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
