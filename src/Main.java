import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Department dept = new Department();
        emplogin empin;
        empin = new emplogin();
        Employee emp = new Employee();
        Salary salary = new Salary();

        Scanner s=new Scanner(System.in);
        String admin_uname = "Shree";
        String admin_pwd = "shree";
        while(true){
            System.out.println("1) Admin Login");
            System.out.println("2) Employee Login");
            System.out.println("Enter your choice (or 'q' to quit): ");
            String choic = s.next();
            if(choic.equalsIgnoreCase("q")) {
                break;
            }
            if(choic.equals("1")) {
                System.out.println("Enter admin username");
                String adm_uname = s.next();
                if(adm_uname.equals(admin_uname)){
                    System.out.println("Enter your password");
                    String adm_pwd = s.next();
                    if(adm_pwd.equals(admin_pwd)){
                        boolean running = true;
                        while (running) {
                            System.out.println("1) Employee");
                            System.out.println("2) Department");
                            System.out.println("3) Salary");
                            System.out.println("Enter your choice (or 'q' to quit): ");
                            String input = s.next();
                            if (input.equalsIgnoreCase("q")) {
                                running = false;
                                continue;
                            }

                            int choice = Integer.parseInt(input);
                            switch (choice) {
                                case 1:
                                    System.out.println("1. Add Employee");
                                    System.out.println("2. Remove Employee");
                                    System.out.println("3. Search Employee");
                                    System.out.println("4. All Employee");
                                    System.out.println("Enter your choice: ");
                                    int empChoice = s.nextInt();
                                    switch (empChoice) {
                                        case 1:
                                            emp.addEmployee();
                                            break;
                                        case 2:
                                            emp.deleteEmployee();
                                            break;
                                        case 3:
                                            emp.searchEmployee();
                                            break;
                                        case 4:
                                            emp.displayEmployee();
                                            break;
                                        default:
                                            System.out.println("Invalid choice for Employee.");
                                    }
                                    break;
                                case 2:
                                    System.out.println("1. Add Department");
                                    System.out.println("2. Remove Department");
                                    System.out.println("3. Display Department");
                                    System.out.println("4. Change Manager");
                                    System.out.println("Enter your choice: ");
                                    int deptChoice = s.nextInt();
                                    switch (deptChoice) {
                                        case 1:
                                            dept.addDepartment();
                                            break;
                                        case 2:
                                            dept.removeDepartment();
                                            break;
                                        case 3:
                                            dept.getAllDepartment();
                                            break;
                                        case 4:
                                            dept.changeManager();
                                            break;
                                        default:
                                            System.out.println("Invalid choice for Department.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("1. Add Salary");
                                    System.out.println("2. Current Salary for emp");
                                    System.out.println("3. Increment Salary");
                                    System.out.println("4. Decrement Salary");
                                    System.out.println("5. Pay salary to employee");
                                    System.out.println("Enter your choice: ");
                                    int salaryChoice = s.nextInt();
                                    switch (salaryChoice) {
                                        case 1:
                                            salary.addSalary();
                                            break;
                                        case 2:
                                            salary.getSalary();
                                            break;
                                        case 3:
                                            salary.increment();
                                            break;
                                        case 4:
                                            salary.decrement();
                                            break;
                                        case 5:
                                            salary.paysalary();
                                            break;
                                        default:
                                            System.out.println("Invalid choice for Salary.");
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid main choice.");
                            }
                        }
                        System.out.println("Exited the program.");
                    }
                    else{
                        System.out.println("Wrong password");
                    }
                }
            }
            else if(choic.equals("2")) {
                empin.login();
            }
            else {
                System.out.println("Invalid Input");
            }

        }

    }
}

