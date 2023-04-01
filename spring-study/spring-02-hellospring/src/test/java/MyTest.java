import com.kuang.pojo.Hello;
import com.kuang.pojo.User;
import com.kuang.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取spring上下文对象
//        执行完这一句，里面的所有对象都初始化了，User对象已经通过无参构造初始化了
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //获取对象
        //getBean : 参数即为spring配置文件中bean的id
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
//
//        //在执行getBean的时候, user已经创建好了 , 通过无参构造
//        User user = (User) context.getBean("user");
//        //调用对象的方法 .
//        user.show();
        UserT userT = (UserT)context.getBean("userT");
        userT.show();
    }
}
