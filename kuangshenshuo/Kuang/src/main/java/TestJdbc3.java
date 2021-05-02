import java.sql.*;

public class TestJdbc3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8解决中文乱
        String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection connection = null;
        try {

            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库，代表数据库
            connection = DriverManager.getConnection(url, username, password);

            connection.setAutoCommit(false);
            String sql = "update users set email = '123@.snnu' where name ='1'";
            connection.prepareStatement(sql).executeUpdate();

            int i = 1/0;

            String sql2 = "update users set email = '12344444@.snnu' where id = 3";
            connection.prepareStatement(sql2).executeUpdate();
            System.out.println("success");
            connection.commit();
        }catch (Exception e){
            try{
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e3){
                e3.printStackTrace();
            }
        }
    }
}
