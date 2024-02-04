package dec_2023.study.jpastudy.user.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class SimpleConnectionMaker {

    @Value("${datasource.driver-class-name}")
    private String className;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String dbUserName;

    @Value("${datasource.password}")
    private String dbPassword;

    public Connection makeNewConnection() throws SQLException, ClassNotFoundException {
        Class.forName(className);
        return DriverManager.getConnection(url, dbUserName, dbPassword);
    }
}
