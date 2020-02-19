package com.example.SpringBootMultiTenancyExample.master;

import com.example.SpringBootMultiTenancyExample.DbProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MasterService {

    public static Map<Object, Object> getDataSourceHashMap(DbProperties dbProperties, DbProperties dbProperties1) {

        //*** PostGre Db Configurations***
        //****Tenant 1 configurations - PostGre DB****
        /*DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("org.postgresql.Driver");
        dataSource1.setUrl("jdbc:postgresql://localhost:5432/demo_database1");
        dataSource1.setUsername("postgres");
        dataSource1.setPassword("root");*/

        //****Tenant 2 configurations - PostGre DB****
   /*     DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName(dbProperties.getDriverClassName());
        dataSource2.setUrl(dbProperties.getUrl());
        dataSource2.setUsername(dbProperties.getUserName());
        dataSource2.setPassword(dbProperties.getPassword());*/
        //spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect


        //*** Oracle Db Configurations***
        //****Tenant 1 configurations - Oracle DB****
       /* DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource1.setUsername("oracleDB1");
        dataSource1.setPassword("root");*/
        //****Tenant 2 Configuration- Oracle Database****
       /* DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource2.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource2.setUsername("oracleDB2");
        dataSource2.setPassword("root");
*/
        //Tenant 1 database configurations --PostGres
        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName(dbProperties.getDriverClassName());
        dataSource1.setUrl(dbProperties.getUrl());
        dataSource1.setUsername(dbProperties.getUserName());
        dataSource1.setPassword(dbProperties.getPassword());
        //Tenant 2 database configurations--Oracle
        DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName(dbProperties1.getDriverClassName());
        dataSource2.setUrl(dbProperties1.getUrl());
        dataSource2.setUsername(dbProperties1.getUserName());
        dataSource2.setPassword(dbProperties1.getPassword());


        HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource1);
        hashMap.put("tenantId2", dataSource2);
        return hashMap;
    }

}
