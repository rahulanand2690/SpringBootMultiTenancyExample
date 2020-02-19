package com.example.SpringBootMultiTenancyExample;

public class TenantContext {
    private static ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
        System.out.println("Tenant in tenentContenxt set " + tenant);
    }

    public static void clear() {
        currentTenant.set(null);
    }
}
