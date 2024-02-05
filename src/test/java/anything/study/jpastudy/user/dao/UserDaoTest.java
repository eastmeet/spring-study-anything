package anything.study.jpastudy.user.dao;

import anything.study.jpastudy.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

class UserDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    @DisplayName("DB에 유저 등록하기 테스트")
    void register_user_test() throws SQLException, ClassNotFoundException {

        // 다형성
        ConnectionMaker connectionMaker = new DConnectionMaker();

        UserDao dao = new UserDao(connectionMaker);

        User user = new User();
        user.setId("eastmeet");
        user.setName("이동우");
        user.setPassword("hi");

        dao.add(user);

        logger.info(user.getId() + " 등록 성공");
    }



    @Test
    @DisplayName("유저_단일조회_테스트")
    void get_user_test() throws SQLException, ClassNotFoundException {

        // 다형성
        ConnectionMaker connectionMaker = new DConnectionMaker();

        User user = new User();
        user.setId("eastmeet");
        user.setName("이동우");
        user.setPassword("hi");

        UserDao dao = new UserDao(connectionMaker);

        User user2 = dao.get(user.getId());
        logger.info(user2.getName());
        logger.info(user2.getPassword());
        logger.info(user2.getId() + " 조회 성공");
    }
}