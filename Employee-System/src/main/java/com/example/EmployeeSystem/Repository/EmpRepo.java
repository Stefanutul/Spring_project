package com.example.EmployeeSystem.Repository;

import com.example.EmployeeSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepo extends JpaRepository<Employee , Integer> {

    @Query("SELECT u FROM Employee u WHERE u.email = ?1")
    public Employee findByEmail(String email);
}
