import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8解决中文乱码
        String url="jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //对数据库操作
        //向数据库发送sql的对象statement
        Statement statement = connection.createStatement();

        //编写sql
        String sql = "select * from users";
        //执行sql，返回结果集
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println("id:"+resultSet.getObject("id"));
            System.out.println("name:"+resultSet.getObject("name"));
            System.out.println("password:"+resultSet.getObject("password"));
            System.out.println("email:"+resultSet.getObject("email"));
            System.out.println("birthday:"+resultSet.getObject("birthday"));

        }

        statement.close();
        connection.close();
    }
}
