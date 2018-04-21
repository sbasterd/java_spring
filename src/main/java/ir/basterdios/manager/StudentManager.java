package ir.basterdios.manager;

import ir.basterdios.dao.StudentDao;
import ir.basterdios.entity.StudentEntity;
import ir.basterdios.dao.StudentDao;
import ir.basterdios.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("studentManager")
public class StudentManager {

    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao = new StudentDao();

    public StudentManager(StudentDao studentDao) {
        this.studentDao = studentDao;
    }




    public boolean save(StudentEntity student) throws SQLException {
        return studentDao.save(student);
    }
}
