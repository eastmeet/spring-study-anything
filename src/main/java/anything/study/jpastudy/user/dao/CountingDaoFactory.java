package anything.study.jpastudy.user.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class CountingDaoFactory {

    @Bean
    public DataSource dataSource() {
        DataSourceProperty property = DataSourceProperty.loadYamlProperties();
        return new DriverManagerDataSource(property.getUrl(), property.getUsername(), property.getPassword());
    }

    @Bean
    // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    public UserDao userDao() {
        UserDao dao = new UserDao();
        dao.setDataSource(dataSource());
        return dao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(this.realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }







}
