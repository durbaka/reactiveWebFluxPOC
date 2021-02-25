package com.WebFlux.reactiveflux.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Employee {
    @Id
    private String id;

    private String name;
    private String doj;
    private String baseLocation;
    private String managerName;

    public Employee() {
    }

    public Employee(String name, String doj, String baseLocation, String managerName) {
        this.name = name;
        this.doj = doj;
        this.baseLocation = baseLocation;
        this.managerName = managerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doj='" + doj + '\'' +
                ", baseLocation='" + baseLocation + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
