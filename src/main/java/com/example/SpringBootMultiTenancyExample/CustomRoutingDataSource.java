package com.example.SpringBootMultiTenancyExample;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();     // get request object
        if (attr != null) {
            String tenantId = TenantContext.getCurrentTenant();
            return tenantId;
        } else {
            return "tenantId2";             // default data source
        }
    }
}
