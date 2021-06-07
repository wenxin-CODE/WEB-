import com.kuang.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }
//    Student{name='longge', address=Address{address='XIan'}, books=[AAA, BBB, CCC], hobbys=[AAAa, BBBb, CCCc],
//    card={身份证=123456, 银行卡=654321}, games=[LOL, COC, BOB], wife='null', info={学号=41812, sex=男}}
}
