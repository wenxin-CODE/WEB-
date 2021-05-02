import java.sql.*;

public class TestJdbc2 {
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

        String sql = "insert into users(id,name,password,email,birthday) values (?,?,?,?,?)";
                //预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,4);
        preparedStatement.setObject(2,1);
        preparedStatement.setObject(3,1);
        preparedStatement.setObject(4,1);
        preparedStatement.setObject(5,new Date(new java.util.Date().getTime()));

        //执行SQL
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("success");
        }
        preparedStatement.close();
        connection.close();
    }
}
