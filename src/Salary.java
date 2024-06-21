import Model.SalaryDAO;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Salary {
    SalaryDAO salary;
    Scanner v=new Scanner(System.in);

    Salary() throws SQLException
    {
        salary = new SalaryDAO();

    }
    public void addSalary() throws SQLException
    {
        int salaryid=salary.getIdSalary();
        System.out.println("Enter your employeeid");
        int employeeid=v.nextInt();
        System.out.println("Enter the basicsalary");
        int basicsalary=v.nextInt();
        System.out.println("Enter the overtime");
        int overtime=v.nextInt();
        System.out.println("Enter the bonus amount");
        int bonus=v.nextInt();

        salary.addSalary(salaryid, employeeid, basicsalary, overtime, bonus);
        System.out.println("Salary added successfully");
    }
    public void increment() throws SQLException{
        System.out.println("Enter which employee to increment");
        int id = v.nextInt();
        System.out.println("How much increment");
        int inc = v.nextInt();
        salary.increment(id, inc);
    }

    public void decrement() throws SQLException{
        System.out.println("Enter which employee to decrement");
        int id = v.nextInt();
        System.out.println("How much decrement");
        int inc = v.nextInt();
        salary.decrement(id, inc);
    }

    public void getSalary() throws SQLException {
        System.out.println("Enter the id of the employee");
        int emp_id = v.nextInt();
        salary.getSalary(emp_id);
    }

    public void paysalary() throws SQLException{
        System.out.println("salary credited");
    }



}
