package dec_2023.study.jpastudy.user.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public interface ConnectionMaker {

    Connection makeConnection() throws SQLException, ClassNotFoundException;

}
