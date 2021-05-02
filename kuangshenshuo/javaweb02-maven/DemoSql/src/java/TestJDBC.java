package java;
import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/test","root","123456");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from user");
            while (rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                    rs=null;
                }
                if (stmt!=null){
                    stmt.close();
                    stmt=null;
                }
                if (conn!=null){
                    conn.close();
                    conn=null;
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }
}
