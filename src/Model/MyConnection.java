package Model;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyConnection{
    public Statement stmt;
    static Connection con;
    public static Connection getConnection() throws SQLException{
//            Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shree","root","shree");
//            stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from employee");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
//            con.close();
        return con;
    }
    public void insertEmployee(int id,String fname,String lname,String dob,String hiredate,String Address,String phoneno, String role) throws SQLException {
        String q1= "INSERT INTO EMPLOYEE VALUES('"+id+"','"+fname+"','"+lname+"','"+dob+"','"+hiredate+"','"+Address+"','"+phoneno+"','"+role+"')";
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

    public int getIdDepartment() throws SQLException {
        int id = 1;
        String q3 = "SELECT * FROM DEPARTMENT";
        ResultSet rs=stmt.executeQuery(q3);
        while(rs.next())
            id = rs.getInt(1) + 1;
        return id;

    }

    public int getIdSalary() throws SQLException {
        int id = 1;
        String q3 = "SELECT * FROM SALARY";
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

    public void addDepartment(int id, String dname, int mid) throws SQLException{
        String q5="INSERT INTO DEPARTMENT VALUES("+id+",'"+dname+"',"+mid+")";
        stmt.executeUpdate(q5);
    }

    public void deleteDepartment(int id) throws SQLException{
        String q5="DELETE FROM DEPARTMENT WHERE DEPARTMENTID = "+id;
        stmt.executeUpdate(q5);
    }

    public void getAllDepartment() throws SQLException {
        String q4="SELECT * FROM Department";
        ResultSet ss=stmt.executeQuery(q4);
        while(ss.next())
            System.out.println(ss.getInt(1)+"  "+ss.getString(2)+"  "+ss.getInt(3));
    }

    public void getSalary(int id) throws SQLException{
        String q = "SELECT * FROM SALARY WHERE EmployeeID = "+id+";";
        ResultSet rs = stmt.executeQuery(q);
        while(rs.next()) {
            System.out.println(rs.getInt(2)+" "+rs.getInt(3));
        }

    }
    public void changeManager(int id, int mid) throws SQLException {
        String query = "UPDATE DEPARTMENT SET MANAGERID = "+mid+" WHERE DEPARTMENTID = "+id+";";
        stmt.executeUpdate(query);
    }

    public void addSalary(int id, int eid, int bs, int ot, int b) throws SQLException{
        String query = "INSERT INTO SALARY VALUES("+id+","+eid+","+bs+","+ot+","+b+");";
        stmt.executeUpdate(query);
    }

    public void increment(int id, int inc) throws SQLException{
        String query = "UPDATE SALARY SET BASICSALARY = BASICSALARY +"+inc+" WHERE EMPLOYEEID = "+id+";";
        stmt.executeUpdate(query);
    }

    public void decrement(int id, int inc) throws SQLException{
        String query = "UPDATE SALARY SET BASICSALARY = BASICSALARY -"+inc+" WHERE EMPLOYEEID = "+id+"" + ";";
        stmt.executeUpdate(query);
    }

    public ArrayList<String> checkemail(String u_name) throws SQLException
    {
        ArrayList<String> al = new ArrayList<>();
        String query = "SELECT * FROM emplogin WHERE email='"+u_name+"';";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            al.add(String.valueOf(rs.getInt(1)));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
        }
        return al;
    }

    public void changePassword(int id, String pwd) throws SQLException{
        String query = "UPDATE EMPLOGIN SET PASSWORD = '"+pwd+"' WHERE EMP_ID = "+id+";";
        stmt.executeUpdate(query);
        System.out.println("Password is successfully changed");
    }

    public void seeDetails(int id) throws SQLException {
        String query = "SELECT * FROM EMPLOYEE JOIN SALARY ON Employdeleteee.EmployeeID=SALARY.EMPLOYEEID WHERE employee.EmployeeID="+id+";";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(11));
        }
    }

    public void addEmpLogin(int id, String username, String pwd) throws SQLException {
        String q = "INSERT INTO EMPLOGIN VALUES("+id+",'"+username+"','"+pwd+"');";
        stmt.executeUpdate(q);
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
            // System.out.println(r.getString(1));
            String q = "SELECT COUNT(*) FROM Attendance WHERE E_ID = "+e_id +" AND date >= "+ r.getString(1).substring(0, 8)+"01" + " AND date <= LAST_DAY(CURRENT_DATE()) ;";
            ResultSet rs = stmt.executeQuery(q);
            while(rs.next()){
                return rs.getInt(1);
            }
        }
        return 0;
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