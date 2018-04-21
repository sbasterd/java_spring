package ir.basterdios.dao;

import ir.basterdios.entity.StudentEntity;
import ir.basterdios.entity.StudentEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("studentDao")
public class StudentDao {
    public StudentDao() {
        System.out.println("created");
    }

    protected Connection connection;
    protected PreparedStatement ps;
    String pass = "123";
    String user = "root";

    private String connectUrl = "jdbc:mysql://127.0.0.1:3306/school";

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectUrl, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @PreDestroy
    @PostConstruct
    protected void finalize() {
        try {
            ps.close();
            connection.close();
        } catch (Exception e) {

        }

    }
    /*this method receives an entity from manager and saves it into database*/
    public Boolean save(StudentEntity entity) throws SQLException {
        String query = "INSERT INTO student(id,name) VALUES(?,?)";
        ps = connection.prepareStatement(query);
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
        ps.executeUpdate();
        return true;
    }

}
