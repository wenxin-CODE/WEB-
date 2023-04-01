import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
       ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");
        user.getCat().shout();
        user.getDog().shout();
        user.getStr();
    }
}
