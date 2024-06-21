import Model.EmployeeDAO;
import Model.employee;
import java.sql.SQLException;
import java.util.Scanner;


public class Employee {
    EmployeeDAO empDao;
    Scanner s;
    public Employee() throws SQLException{
        empDao = new EmployeeDAO();
        s = new Scanner(System.in);
    }

    public void addEmployee() throws SQLException {
        int id = empDao.getIdEmployee();
        System.out.println("Enter your first name");
        String fname = s.nextLine();
        System.out.println("Enter your last name");
        String lname = s.nextLine();
        System.out.println("Enter your Date of Birth (YYYY-MM-DD)");
        String dob = s.nextLine();
        System.out.println("Enter your hire date");
        String hdate = s.nextLine();
        System.out.println("Enter your Address");
        String add = s.nextLine();
        System.out.println("Enter your Phone Number");
        String phone = s.nextLine();
        System.out.println("Enter your Role");
        String role = s.nextLine();

        employee emp = new employee();
        emp.setId(id);
        emp.setFname(fname);
        emp.setLname(lname);
        emp.setDateofbirth(dob);
        emp.setHiredate(hdate);
        emp.setAddress(add);
        emp.setPhoneno(phone);
        emp.setRole(role);
        empDao.insertEmployee(emp);
//        empDao.addEmpLogin(id, fname+phone.substring(0,5), phone);
        System.out.println("Employee added successfully");

    }
    public void deleteEmployee() throws SQLException {
        System.out.println("Enter the id of the employee to remove");
        int id = s.nextInt();
        empDao.deleteEmployee(id);
        System.out.println("Employee removed successfully");
    }
    public void searchEmployee() throws SQLException{
        System.out.println("Enter the name of the employee to search");
        String name=s.nextLine();
        empDao.searchEmployee(name);
        System.out.println("Employee searched successfully");
    }

    public void displayEmployee() throws SQLException{
        System.out.println("Enter the employee details ");
        empDao.displayEmployee();
        System.out.println("Enter the employee details");
    }


    public void options(int id) throws SQLException {
        boolean running = true;

        while (running) {
            System.out.println("1) See Details");
            System.out.println("2) Change password");
            System.out.println("3) Mark Attendance");
            System.out.println("4) No of Days Present");
            System.out.println("Enter your choice (or 'q' to quit): ");

            String choice = s.nextLine().trim();

            switch (choice) {
                case "1":
                    empDao.seeDetails(id);
                    break;
                case "2":
                    System.out.println("Enter new password");
                    String new_pwd = s.next();
                    empDao.changePassword(id, new_pwd);
                    break;
                case "3":
                    if (empDao.validateAttendance(id)) {
                    System.out.println("Attendance already marked today.");
                    }
                    else{
                        empDao.markAttendance(id);
                        System.out.println("Attendance marked.");
                    } case "4":
                    System.out.println(empDao.howManyAttendance(id));
                        break;
                case "q":
                    System.out.println("Exiting the menu.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }

}
