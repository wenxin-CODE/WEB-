import com.kuang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class Testx {
    @Test
    public void test(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationCOntext.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user.name);
    }
}
