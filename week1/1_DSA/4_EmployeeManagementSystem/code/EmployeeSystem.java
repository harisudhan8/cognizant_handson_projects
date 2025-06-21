import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " - " + name + " | " + position + " | ₹" + salary;
    }
}

public class EmployeeSystem {
    static Employee[] employees = new Employee[100];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Position: ");
        String position = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        employees[count++] = new Employee(id, name, position, salary);
        System.out.println("Employee added successfully!\n");
    }

    public static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found:");
                System.out.println(employees[i] + "\n");
                return;
            }
        }
        System.out.println("Employee not found.\n");
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted successfully!\n");
                return;
            }
        }
        System.out.println("Employee not found.\n");
    }

    public static void listEmployees() {
        if (count == 0) {
            System.out.println("No employees to show.\n");
            return;
        }

        System.out.println("Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("==== Employee Management System ====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Show All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    addEmployee();
                    break;
                case "2":
                    searchEmployee();
                    break;
                case "3":
                    deleteEmployee();
                    break;
                case "4":
                    listEmployees();
                    break;
                case "5":
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
