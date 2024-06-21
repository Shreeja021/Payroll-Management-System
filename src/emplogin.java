import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Model.EmpLoginDAO;

import java.sql.*;

public class emplogin
{
    Scanner s;
    EmpLoginDAO empLogin;

    public emplogin() throws SQLException {
        s = new Scanner(System.in);
        empLogin = new EmpLoginDAO();
    }

    public boolean login() throws SQLException {
        String u_name;
        String pwd;
        while(true) {
            System.out.println("Enter your username");
            u_name = s.next();
            ArrayList<String> al = empLogin.checkemail(u_name);
            if(al.size()==0){
                System.out.println("You have entered a wrong username");
            }
            else{
                System.out.println("Enter your password");
                pwd = s.next();
                if(pwd.equals(al.get(2))){
                    Employee emp = new Employee();
                    emp.options(Integer.parseInt(al.get(0)));
                }
                else{
                    System.out.println("You have entered a wrong password");
                }
            }

        }
    }
}
