package dec_2023.study.jpastudy.user.dao;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {

    @Value("${datasource.driver-class-name}")
    private String className;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String dbUserName;

    @Value("${datasource.password}")
    private String dbPassword;

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName(className);
        return DriverManager.getConnection(url, dbUserName, dbPassword);
    }
}
