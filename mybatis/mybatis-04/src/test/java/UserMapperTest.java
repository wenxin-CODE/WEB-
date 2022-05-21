import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import com.kuang.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //依靠反射到底层获取信息
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUser();
        for (User user:userList) {
            System.out.println(user);
        }

//        User userid = mapper.getUserById(2);
//        System.out.println(userid);

//        User user = new User(4,"aini","1234321");
//        int i = mapper.addUser(user);
//
//        int i = mapper.updatwUser(new User(7, "labulado", "1234567"));
//        if (i>0){
//            System.out.println("success");
//        }
//        sqlSession.close();
        //添加时必须有提交事务的操作
    }
}
