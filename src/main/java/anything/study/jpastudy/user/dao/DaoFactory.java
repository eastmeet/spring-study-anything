package anything.study.jpastudy.user.dao;

public class DaoFactory {

    public UserDao userDao() {
        ConnectionMaker connectionMaker = initConnectionMaker();
        return new UserDao(connectionMaker);
    }

    private ConnectionMaker initConnectionMaker() {
        return new DConnectionMaker();
    }
}
