package dec_2023.study.jpastudy.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
