package com.example.SpringBootMultiTenancyExample;

import lombok.Data;

@Data
public class DbProperties {

    public String Name;
    public String DriverClassName;
    public String Url;
    public String UserName;
    public String password;

}
