package com.example.ms.services.employee.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import com.example.ms.services.employee.model.Employee;
import com.example.ms.services.employee.repository.EmployeeRepository;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class EmployeeControllerTests {

    @Inject
    EmployeeRepository repository;

    @Test
    public void testFindAll() {
        // TODO
        given().when().get("/impiegati").then().statusCode(200).body(notNullValue());
    }

    @Test
    public void testFindById() {
        Employee employee = new Employee(1L, 1L, "Adrien Hamilton", 33, "Developer");
        employee = repository.add(employee);
        given().when().get("/employees/{id}", employee.getId()).then().statusCode(200)
                .body("id", equalTo(employee.getId().intValue()))
                // TODO
                .body("name", equalTo("Joe"))
                .body("position", equalTo(employee.getPosition()));
    }

    @Test
    public void testFindByDepartment() {
        given().when().get("/employees/department/{departmentId}", 1L).then().statusCode(200).body(notNullValue());
    }

    @Test
    public void testAdd() {
        Employee employee = new Employee(1L, 1L, "Josh Stevens", 23, "Developer");
        given().contentType("application/json").body(employee)
                .when().post("/employees").then().statusCode(200)
                    .body("id", notNullValue())
                    .body("name", equalTo(employee.getName()))
                    .body("position", equalTo(employee.getPosition()));
    }

    @Test
    public void testInvalidAdd() {
        Employee employee = new Employee();
        given().contentType("application/json").body(employee).when().post("/employees").then().statusCode(400);
    }

}
