package com.codegym.model.employee;

import com.codegym.model.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(int id, String name, List<Employee> employees) {
        this.id = id;
        Name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
