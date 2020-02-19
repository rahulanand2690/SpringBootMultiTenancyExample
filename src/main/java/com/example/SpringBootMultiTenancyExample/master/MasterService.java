package com.example.SpringBootMultiTenancyExample.master;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.Map;

public class MasterService {

    public static Map<Object, Object> getDataSourceHashMap() {

        //*** PostGre Db Configurations***
        //****Tenant 1 configurations - PostGre DB****
        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("org.postgresql.Driver");
        dataSource1.setUrl("jdbc:postgresql://localhost:5432/demo_database1");
        dataSource1.setUsername("postgres");
        dataSource1.setPassword("root");

        //****Tenant 1 configurations - PostGre DB****
        DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName("org.postgresql.Driver");
        dataSource2.setUrl("jdbc:postgresql://localhost:5432/demo_database2");
        dataSource2.setUsername("postgres");
        dataSource2.setPassword("root");
        //spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect


        //*** Oracle Db Configurations***
        //****Tenant 1 configurations - Oracle DB****
       /* DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource1.setUsername("oracleDB1");
        dataSource1.setPassword("root");
        //****Tenant 2 Configuration- Oracle Database****
        DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource2.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource2.setUsername("oracleDB2");
        dataSource2.setPassword("root");*/


        HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource1);
        hashMap.put("tenantId2", dataSource2);
        return hashMap;
    }
}
