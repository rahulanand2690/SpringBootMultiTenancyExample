package com.example.SpringBootMultiTenancyExample.master;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.HashMap;
import java.util.Map;

public class MasterService {

    public static Map<Object, Object> getDataSourceHashMap() {

        /*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo_database");
        dataSource.setUsername("root");
        dataSource.setPassword("");*/

        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("org.postgresql.Driver");
        dataSource1.setUrl("jdbc:postgresql://localhost:5432/demo_database1");
        dataSource1.setUsername("postgres");
        dataSource1.setPassword("root");

        //spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect


        DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName("org.postgresql.Driver");
        dataSource2.setUrl("jdbc:postgresql://localhost:5432/demo_database2");
        dataSource2.setUsername("postgres");
        dataSource2.setPassword("root");

        HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource1);
        hashMap.put("tenantId2", dataSource2);
        return hashMap;
    }
}
