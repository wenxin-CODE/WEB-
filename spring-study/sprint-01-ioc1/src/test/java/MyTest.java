import com.kuang.dao.UserDaoImpl;
import com.kuang.dao.UserDaoMysqlImpl;
import com.kuang.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        //用户调用业务层（service），不用接触dao
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
