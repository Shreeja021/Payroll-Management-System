package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpLoginDAO {
    public Connection con;
    public Statement stmt;
    public EmpLoginDAO() throws SQLException {
        con = MyConnection.getConnection();
        stmt = con.createStatement();
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

    public void addEmpLogin(int id, String username, String pwd) throws SQLException {
        String q = "INSERT INTO EMPLOGIN VALUES("+id+",'"+username+"','"+pwd+"');";
        stmt.executeUpdate(q);
    }
}
