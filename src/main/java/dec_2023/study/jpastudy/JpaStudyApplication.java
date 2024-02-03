package dec_2023.study.jpastudy;

import dec_2023.study.jpastudy.user.dao.UserDao;
import dec_2023.study.jpastudy.user.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class JpaStudyApplication implements CommandLineRunner {

    private final UserDao dao;

    public JpaStudyApplication(UserDao userDao) {
        this.dao = userDao;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(JpaStudyApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setId("eastmeet");
        user.setName("이동우");
        user.setPassword("hi");

        dao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + "조회 성공");
    }
}
