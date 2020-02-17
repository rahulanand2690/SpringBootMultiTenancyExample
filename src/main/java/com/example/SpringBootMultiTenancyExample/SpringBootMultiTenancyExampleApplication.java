package com.example.SpringBootMultiTenancyExample;

import com.example.SpringBootMultiTenancyExample.master.MasterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = "com.example.SpringBootMultiTenancyExample")
@ComponentScan("com.example.SpringBootMultiTenancyExample")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.SpringBootMultiTenancyExample")
public class SpringBootMultiTenancyExampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootMultiTenancyExampleApplication.class, args);
	}

	@Bean
	public DataSource dataSource(){
		CustomRoutingDataSource customDataSource=new CustomRoutingDataSource();
		customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
		return customDataSource;
	}

}
