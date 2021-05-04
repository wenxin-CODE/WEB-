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
        sqlSession.close();
    }
}
