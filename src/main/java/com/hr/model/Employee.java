package com.hr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findBySalary", query ="select emp from Employee emp where salary" +
        " >= :salary AND name LIKE :name")
public class Employee {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private Double salary;

    @Transient
    private Boolean isCreated;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department department;


    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Version
    private Long version;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
