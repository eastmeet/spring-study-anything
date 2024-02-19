package anything.user.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@Slf4j
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperty {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    public static DataSourceProperty loadYamlProperties() {

        Yaml yaml = new Yaml();

        try (InputStream input = NConnectionMaker.class.getClassLoader().getResourceAsStream("env.yml")) {

            if (input == null) {
                log.info("Sorry, unable to find application.yml");
            }

            Map<String, Object> properties = yaml.load(input);
            Map<String, String> datasource = (Map<String, String>) properties.get("datasource");
            DataSourceProperty dataSourceProperty = new DataSourceProperty();
            dataSourceProperty.setDriverClassName(datasource.get("driver-class-name"));
            dataSourceProperty.setUrl(datasource.get("url"));
            dataSourceProperty.setUsername(datasource.get("username"));
            dataSourceProperty.setPassword(datasource.get("password"));
            return dataSourceProperty;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
