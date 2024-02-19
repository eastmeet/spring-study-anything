package anything.user.dao;


import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public interface ConnectionMaker {

    Connection makeConnection() throws SQLException, ClassNotFoundException;

}
