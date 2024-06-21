import Model.MyConnection;

import java.sql.SQLException;
import java.util.Scanner;

public class Department
{
    MyConnection conn=new MyConnection();
    Scanner s=new Scanner(System.in);
    Department()
    {

    }
    public void addDepartment() throws SQLException {
        int id = conn.getIdDepartment();
        System.out.println("Enter your Departmentname");
        String dname = s.nextLine();
        System.out.println("Enter Manager id");
        int managerid = s.nextInt();
        conn.addDepartment(id,dname,managerid);
        System.out.println("Department added successfully");
    }

    public void removeDepartment() throws SQLException{
        System.out.println("Enter the departmentid to remove");
        int id = s.nextInt();

        conn.deleteDepartment(id);
        System.out.println("department removed successfully");
}
    public void getAllDepartment() throws SQLException {
        MyConnection conn = new MyConnection();
        conn.getAllDepartment();
    }

    public void changeManager() throws SQLException {
        System.out.println("Enter the id of the Department Manager to change");
        int id = s.nextInt();
        System.out.println("Enter the id of the new Manager");
        int mid = s.nextInt();
        conn.changeManager(id, mid);
    }
}
