package com.example.EmployeeSystem.Repository;

import com.example.EmployeeSystem.Entity.Contestant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContestantRepo extends JpaRepository<Contestant, Integer> {
}
