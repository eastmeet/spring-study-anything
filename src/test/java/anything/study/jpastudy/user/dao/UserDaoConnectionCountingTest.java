package anything.study.jpastudy.user.dao;

import anything.study.jpastudy.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

class UserDaoConnectionCountingTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoConnectionCountingTest.class);

    @Test
    @DisplayName("DB에 유저 등록하기 테스트")
    @Order(1)
    void register_user_test() throws SQLException, ClassNotFoundException {

        // 애플리케이션 컨텍스트 적용 -> 의존관계 검색
        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);
        UserDao dao1 = context.getBean("userDao", UserDao.class);

        CountingDaoFactory countingDaoFactory = new CountingDaoFactory();
        UserDao dao2 = countingDaoFactory.userDao();
        UserDao dao3 = countingDaoFactory.userDao();

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
        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());
        logger.info(user.getId() + " 등록 성공");

        // UserDao 사용
        User user2 = dao.get(user.getId());
        logger.info(user2.getName());
        logger.info(user2.getPassword());
        logger.info(user2.getId() + " 조회 성공");
        System.out.println("Connection counter : " + ccm.getCounter());
    }

    @Test
    @DisplayName("유저_단일조회_테스트")
    void get_user_test() throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("eastmeet");
        user.setName("이동우");
        user.setPassword("hi");

        // UserDao 사용
        User user2 = dao.get(user.getId());

        if (!user.getName().equals(user2.getName())) {
            logger.info("테스트 실패 (name)");
        } else if (!user.getPassword().equals(user2.getPassword())) {
            logger.info("테스트 실패 (password)");
        } else {
            logger.info("조회 테스트 성공");
        }

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);

        Assertions.assertThat(ccm.getCounter()).isEqualTo(1);
    }

    @Test
    @DisplayName("DB_커넥션_카운팅_테스트")
    void count_connection_test() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());
    }
}