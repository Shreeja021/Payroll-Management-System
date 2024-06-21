package Model;
import java.sql.*;

public class SalaryDAO {
    Connection con;
    Statement stmt;
    public SalaryDAO() throws SQLException {
        con = MyConnection.getConnection();
        stmt = con.createStatement();

    }

    public void getSalary(int id) throws SQLException{
        String q = "SELECT * FROM SALARY WHERE EmployeeID = "+id+";";
        ResultSet rs = stmt.executeQuery(q);
        while(rs.next()) {
            System.out.println(rs.getInt(2)+" "+rs.getInt(3));
        }

    }
    public int getIdSalary() throws SQLException {
        int id = 1;
        String q3 = "SELECT * FROM SALARY";
        ResultSet rs=stmt.executeQuery(q3);
        while(rs.next())
            id = rs.getInt(1) + 1;
        return id;

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
}
