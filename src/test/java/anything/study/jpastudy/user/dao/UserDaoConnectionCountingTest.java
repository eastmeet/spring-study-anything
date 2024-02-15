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
    void user_add_and_get() throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("eastmeet");
        user.setName("이동우");
        user.setPassword("hitest");

        dao.add(user);

        User user2 = dao.get(user.getId());
        Assertions.assertThat(user2.getName()).isEqualTo(user.getName());
        Assertions.assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }


}