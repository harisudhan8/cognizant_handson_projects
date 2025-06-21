import java.util.Scanner;

class Task {
    int taskId;
    String taskName, status;
    Task next;

    Task(int id, String name, String status) {
        taskId = id;
        taskName = name;
        this.status = status;
    }

    public String toString() {
        return taskId + " - " + taskName + " [" + status + "]";
    }
}

public class TaskManager{
    static Task head = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Task Manager ====");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Mark Task as Done");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Task ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Status (Pending/Done): ");
                    String status = sc.nextLine();
                    Task newTask = new Task(id, name, status);
                    if (head == null) {
                        head = newTask;
                    } else {
                        Task temp = head;
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        temp.next = newTask;
                    }
                    System.out.println("Task added.");
                    break;

                case "2":
                    System.out.print("Enter Task ID to delete: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    if (head != null && head.taskId == delId) {
                        head = head.next;
                        System.out.println("Task deleted.");
                    } else {
                        Task temp = head;
                        while (temp != null && temp.next != null && temp.next.taskId != delId) {
                            temp = temp.next;
                        }
                        if (temp != null && temp.next != null) {
                            temp.next = temp.next.next;
                            System.out.println("Task deleted.");
                        } else {
                            System.out.println("Task not found.");
                        }
                    }
                    break;

                case "3":
                    if (head == null) {
                        System.out.println("No tasks available.");
                    } else {
                        Task t = head;
                        while (t != null) {
                            System.out.println(t);
                            t = t.next;
                        }
                    }
                    break;

                case "4":
                    System.out.print("Enter Task ID to mark as Done: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    Task current = head;
                    boolean found = false;
                    while (current != null) {
                        if (current.taskId == updateId) {
                            current.status = "Done";
                            System.out.println("Task status updated to Done.");
                            found = true;
                            break;
                        }
                        current = current.next;
                    }
                    if (!found) {
                        System.out.println("Task not found.");
                    }
                    break;

                case "5":
                    System.out.println("Exiting Task Manager...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
