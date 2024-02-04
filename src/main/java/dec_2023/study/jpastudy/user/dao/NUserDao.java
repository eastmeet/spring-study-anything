package dec_2023.study.jpastudy.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {

    public NUserDao(SimpleConnectionMaker simpleConnectionMaker) {
        super(simpleConnectionMaker);
    }

}
