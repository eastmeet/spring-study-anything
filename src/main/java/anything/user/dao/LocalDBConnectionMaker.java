package anything.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class LocalDBConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        return null;
    }

}
