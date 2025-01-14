package com.example.ms.services.department.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    @NotNull
    private Long organizationId;
    @NotBlank
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department() {

    }

    public Department(Long organizationId, String name) {
        super();
        this.organizationId = organizationId;
        // TODO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", organizationId=" + organizationId + ", name=" + name + "]";
    }

}
