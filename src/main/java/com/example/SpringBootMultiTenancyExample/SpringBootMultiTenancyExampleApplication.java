package com.example.SpringBootMultiTenancyExample;

import com.example.SpringBootMultiTenancyExample.master.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.example.SpringBootMultiTenancyExample")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.SpringBootMultiTenancyExample")
//@ComponentScan(basePackages = "com.example.SpringBootMultiTenancyExample")
//@Import(RestClientConfig.class)
//@Import(WebMvcConfig.class)
public class SpringBootMultiTenancyExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMultiTenancyExampleApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();
        customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap(DbPropertyBean(),DbPropertyBean1()));
        return customDataSource;
    }
    DbProperties dbProperties = new DbProperties();
    @Autowired
    private Environment environment;
    @Bean
    public DbProperties DbPropertyBean(){

        DbProperties dbProperties = new DbProperties();
        dbProperties.setDriverClassName(environment.getProperty("postgre.DriverClassName"));
        dbProperties.setUrl((environment.getProperty("postgre.Url")));
        dbProperties.setUserName((environment.getProperty("postgre.UserName")));
        dbProperties.setPassword(environment.getProperty("postgre.password"));
        return  dbProperties;
    }

    @Bean
    public DbProperties DbPropertyBean1(){

        DbProperties dbProperties = new DbProperties();
        dbProperties.setDriverClassName(environment.getProperty("oracle.DriverClassName"));
        dbProperties.setUrl((environment.getProperty("oracle.Url")));
        dbProperties.setUserName((environment.getProperty("oracle.UserName")));
        dbProperties.setPassword(environment.getProperty("oracle.password"));
        return  dbProperties;
    }

}
