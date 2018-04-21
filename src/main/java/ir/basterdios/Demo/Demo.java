package ir.basterdios.Demo;

import ir.basterdios.config.AppConfig;
import ir.basterdios.entity.StudentEntity;
import ir.basterdios.manager.StudentManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

public class Demo {
    public static void main(String[] args) throws SQLException {

        StudentEntity student1 = new StudentEntity();
        student1.setId(new Random().nextInt(100) + 1);
        student1.setName("Kalim");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context2 = new ClassPathXmlApplicationContext("context.xml");


        StudentManager studentManager = context2.getBean(StudentManager.class);
        StudentManager studentManager2 = context2.getBean(StudentManager.class);
        studentManager.save(student1);
        ((ClassPathXmlApplicationContext) context2).close();
        System.out.println("DONE");
    }
}
