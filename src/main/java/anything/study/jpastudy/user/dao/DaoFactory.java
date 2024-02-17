package anything.study.jpastudy.user.dao;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

// 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {

    private final DataSourceProperty property = DataSourceProperty.loadYamlProperties();

    // datasource 설정
    @Bean
    public UserDao userDao() {
        UserDao dao = new UserDao();
        dao.setDataSource(hikariDataSource());
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

    @Bean
    public DataSource driveManagerdataSource() {
        return new DriverManagerDataSource(property.getUrl(), property.getUsername(), property.getPassword());
    }

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(property.getDriverClassName()));
        dataSource.setUrl(property.getUrl());
        dataSource.setUsername(property.getUsername());
        dataSource.setPassword(property.getPassword());
        return new DriverManagerDataSource(property.getUrl(), property.getUsername(), property.getPassword());
    }

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(property.getDriverClassName());
        dataSource.setJdbcUrl(property.getUrl());
        dataSource.setUsername(property.getUsername());
        dataSource.setPassword(property.getPassword());
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("eastmeetPool");

        return dataSource;
    }










}
