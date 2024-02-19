package anything.user.dao;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

@Slf4j
public class DConnectionMaker implements ConnectionMaker {

    private String className;

    private String url;

    private String dbUserName;

    private String dbPassword;

    public DConnectionMaker() {
        loadYamlProperties();
    }

    private void loadYamlProperties() {
        Yaml yaml = new Yaml();
        try (InputStream input = NConnectionMaker.class.getClassLoader().getResourceAsStream("env.yml")) {
            if (input == null) {
                log.info("Sorry, unable to find application.yml");
                return;
            }

            Map<String, Object> properties = yaml.load(input);
            Map<String, String> datasource = (Map<String, String>) properties.get("datasource");
            className = datasource.get("driver-class-name");
            url = datasource.get("url");
            dbUserName = datasource.get("username");
            dbPassword = datasource.get("password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName(className);
        return DriverManager.getConnection(url, dbUserName, dbPassword);
    }
}