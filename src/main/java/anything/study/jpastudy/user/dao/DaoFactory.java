package anything.study.jpastudy.user.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {

    @Bean
    // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    public UserDao userDao() {
        ConnectionMaker connectionMaker = initConnectionMaker();
        return new UserDao(connectionMaker);
    }

    @Bean
    public ConnectionMaker initConnectionMaker() {
        return new DConnectionMaker();
    }

    // 개발용
//    @Bean
//    public ConnectionMaker connectionMaker() {
//        return new LocalDBConnectionMaker();
//    }

//    운영용
//    @Bean
//    public ConnectionMaker connectionMaker() {
//        return new ProductDBConnectionMaker();
//    }


}
