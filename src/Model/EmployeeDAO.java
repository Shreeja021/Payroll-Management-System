package Model;

import java.sql.*;
import java.sql.Statement;

public class EmployeeDAO {
    public Connection con;
    public Statement stmt;
    public EmployeeDAO() throws SQLException{
        con = MyConnection.getConnection();
        stmt = con.createStatement();
    }

    public void insertEmployee(employee emp) throws SQLException {
        String q1= "INSERT INTO EMPLOYEE VALUES('"+emp.getId()+"','"+emp.getFname()+"','"+emp.getLname()+"','"+emp.getDateofbirth()+"','"+emp.getHiredate()+"','"+emp.getAddress()+"','"+emp.getPhoneno()+"','"+emp.getRole()+"')";
        stmt.executeUpdate(q1);
    }
    public void deleteEmployee(int id) throws SQLException{
        String q = "DELETE FROM SALARY WHERE EmployeeID = "+id;
        stmt.executeUpdate(q);
        String q2="DELETE FROM EMPLOYEE WHERE Employeeid="+id;
        stmt.executeUpdate(q2);
    }

    public void searchEmployee(String name) throws SQLException{
        String q3="SELECT * FROM EMPLOYEE WHERE FirstName='"+name+"'";
        ResultSet rs=stmt.executeQuery(q3);
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
    }

    public int getIdEmployee() throws SQLException {
        int id = 1;
        String q3 = "SELECT * FROM EMPLOYEE";
        ResultSet rs=stmt.executeQuery(q3);
        while(rs.next())
            id = rs.getInt(1) + 1;
        return id;

    }
    public void displayEmployee()  throws SQLException{
        String q4="SELECT * FROM EMPLOYEE";
        ResultSet ss=stmt.executeQuery(q4);
        while(ss.next())
            System.out.println(ss.getInt(1)+"  "+ss.getString(2)+"  "+ss.getString(3)+" "+ss.getString(4)+" "+ss.getString(5));
    }

    public void changePassword(int id, String pwd) throws SQLException{
        String query = "UPDATE EMPLOGIN SET PASSWORD = '"+pwd+"' WHERE EMP_ID = "+id+";";
        stmt.executeUpdate(query);
        System.out.println("Password is successfully changed");
    }

    public boolean validateAttendance(int e_id) throws SQLException {
        String q = "SELECT * FROM ATTENDANCE WHERE E_ID = "+e_id+" AND DATE = CURRENT_DATE();";
        ResultSet rs = stmt.executeQuery(q);
        if (rs.next()){
            return true;
        }
        return false;
    }

    public int howManyAttendance(int e_id) throws SQLException {
        String q1 = "SELECT CURRENT_DATE();";
        ResultSet r = stmt.executeQuery(q1);
        while(r.next()) {
            String q = "SELECT COUNT(*) FROM Attendance WHERE E_ID = "+e_id +" AND date >= "+ r.getString(1).substring(0, 8)+"01" + " AND date <= LAST_DAY(CURRENT_DATE()) ;";
            ResultSet rs = stmt.executeQuery(q);
            while(rs.next()){
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public void seeDetails(int id) throws SQLException {
        String query = "SELECT * FROM EMPLOYEE JOIN SALARY ON Employee.EmployeeID=SALARY.EMPLOYEEID WHERE employee.EmployeeID="+id+";";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(11));
        }
    }


    public void markAttendance(int e_id) throws SQLException {
        String q = "INSERT INTO ATTENDANCE VALUES("+e_id+", CURRENT_DATE(), 'PRESENT');";
        stmt.executeUpdate(q);
    }

    public boolean empCheckAttendance(int id) throws SQLException {
        String q = "select * from attendance WHERE E_ID = "+id+" AND date = CURRENT_DATE();";
        ResultSet rs = stmt.executeQuery(q);
        while(rs.next()) {
            return true;
        }
        return false;
    }

}
