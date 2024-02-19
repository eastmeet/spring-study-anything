package anything.study.jpastudy.user.dao;

import anything.user.dao.DaoFactory;
import anything.user.dao.DataSourceProperty;
import anything.user.dao.UserDao;
import anything.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

class UserDaoConnectionCountingTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoConnectionCountingTest.class);

    @Test
    void user_add_and_get() throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user1 = new User("eastmeet", "이동우", "hitest");
        User user2 = new User("hong", "홍길동", "hiDB");

        dao.deleteAll();
        Assertions.assertThat(dao.getCount()).isZero();

        dao.add(user1);
        dao.add(user2);
        Assertions.assertThat(dao.getCount()).isEqualTo(2);

        User userGet1 = dao.get(user1.getId());
        Assertions.assertThat(user1.getName()).isEqualTo(userGet1.getName());
        Assertions.assertThat(user1.getPassword()).isEqualTo(userGet1.getPassword());

        User userGet2 = dao.get(user2.getId());
        Assertions.assertThat(user2.getName()).isEqualTo(userGet2.getName());
        Assertions.assertThat(user2.getPassword()).isEqualTo(userGet2.getPassword());
    }

    @Test
    void count() throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user1 = new User("eastmeet", "이동우", "hitest");
        User user2 = new User("hong", "홍길동", "hiDB");
        User user3 = new User("duli", "둘리", "hipa");

        dao.deleteAll();
        Assertions.assertThat(dao.getCount()).isZero();

        dao.add(user1);
        Assertions.assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        Assertions.assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        Assertions.assertThat(dao.getCount()).isEqualTo(3);
    }

    @Test
    void loadYamlProperties_Test() {
        DataSourceProperty property = DataSourceProperty.loadYamlProperties();
        logger.info("===========================================================");
        Assertions.assertThat(property).isNotNull();
        Assertions.assertThat(property.getDriverClassName()).isNotNull();
        Assertions.assertThat(property.getUrl()).isNotNull();
        Assertions.assertThat(property.getUsername()).isNotNull();
        Assertions.assertThat(property.getPassword()).isNotNull();
        logger.info(property.getDriverClassName());
        logger.info(property.getUrl());
        logger.info(property.getUsername());
        logger.info(property.getPassword());
        logger.info("===========================================================");
    }

    @Test
    void datasource_Test() throws SQLException {

        DataSource dataSource = new DaoFactory().hikariDataSource();

        Connection connection1 = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();

        Assertions.assertThat(connection1).isNotNull();
        Assertions.assertThat(connection2).isNotNull();
        logger.info("connection={}, class={}", connection1, connection1.getClass());
        logger.info("connection={}, class={}", connection2, connection2.getClass());

    }

    @Test
    @DisplayName("pool max 초과 테스트")
    @Disabled
    void hikariCP_Test() throws SQLException {

        // pool max는 10개 설정
        DataSource dataSource = new DaoFactory().hikariDataSource();

        for (int i = 0; i < 20; i++) {
            Connection connection = dataSource.getConnection();
            Assertions.assertThat(connection).isNotNull();
            logger.info("connection count={}", i + 1);
            logger.info("connection={}, class={}", connection, connection.getClass());
        }
    }

}