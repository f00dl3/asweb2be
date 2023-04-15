package asweb2.backend.repository.JDBC;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class CoreDataSourceConfig {

    @Autowired
    private Environment env;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "coreData")
    @Primary
    public DataSource coreData() {
        System.out.println("Created coreData bean... for " + driverClassName);
        return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
    }

    @Bean(name = "jdbcCoreDataService")
    @Autowired
    public JdbcTemplate createJdbcTemplate_ProductService(@Qualifier("coreData") DataSource coreServiceDS) {
        System.out.println("Created jdbcCoreDataService successfully...");
        return new JdbcTemplate(coreServiceDS);
    }

}
