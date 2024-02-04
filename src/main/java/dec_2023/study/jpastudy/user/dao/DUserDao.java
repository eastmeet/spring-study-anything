package dec_2023.study.jpastudy.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao {

    public DUserDao(SimpleConnectionMaker simpleConnectionMaker) {
        super(simpleConnectionMaker);
    }
}
