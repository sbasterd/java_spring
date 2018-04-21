package ir.basterdios.config;

import ir.basterdios.dao.StudentDao;
import ir.basterdios.manager.StudentManager;
import ir.basterdios.dao.StudentDao;
import ir.basterdios.manager.StudentManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ir.basterdios")
public class AppConfig {
    /*@Bean(value = "studentDao", destroyMethod = "finalize")
    public StudentDao getStudentDao() {
        return new StudentDao();
    }

    @Bean("studentManager")
    public StudentManager getStudentManager() {
        return new StudentManager(getStudentDao());
    }*/


}
