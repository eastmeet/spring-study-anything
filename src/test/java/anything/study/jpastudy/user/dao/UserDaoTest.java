package anything.study.jpastudy.user.dao;

import anything.study.jpastudy.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

class UserDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    @DisplayName("DB에 유저 등록하기 테스트")
    void register_user_test() throws SQLException, ClassNotFoundException {

        // 애플리케이션 컨텍스트 적용
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);
        UserDao dao1 = context.getBean("userDao", UserDao.class);

        DaoFactory daoFactory = new DaoFactory();
        UserDao dao2 = daoFactory.userDao();
        UserDao dao3 = daoFactory.userDao();

        // dao == dao1 -> 동일성 identity
        // 싱글톤(Singleton)
        System.out.println(dao); //UserDao@733c423e
        System.out.println(dao1); //UserDao@733c423e
        System.out.println(dao == dao1);

        // dao2 != dao3 ->
        System.out.println(dao2); // UserDao@51684e4a
        System.out.println(dao3); // UserDao@6ce1f601
        System.out.println(dao2 == dao3);

        User user = new User();
        user.setId("eastmeet");
        user.setName("이동우");
        user.setPassword("hi");

        // UserDao 사용
        dao.add(user);

        logger.info(user.getId() + " 등록 성공");
    }

    @Test
    @DisplayName("유저_단일조회_테스트")
    void get_user_test() throws SQLException, ClassNotFoundException {

        // 다형성: DConnectionMaker 사용
        ConnectionMaker connectionMaker = new DConnectionMaker();

        // UserDao 생성
        UserDao dao = new UserDao(connectionMaker);

        User user = new User();
        user.setId("eastmeet");
        user.setName("이동우");
        user.setPassword("hi");

        // UserDao 사용
        User user2 = dao.get(user.getId());
        logger.info(user2.getName());
        logger.info(user2.getPassword());
        logger.info(user2.getId() + " 조회 성공");
    }
}