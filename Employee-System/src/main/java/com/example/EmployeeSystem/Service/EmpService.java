package com.example.EmployeeSystem.Service;

import com.example.EmployeeSystem.Entity.Employee;
import com.example.EmployeeSystem.Entity.User;
import com.example.EmployeeSystem.Repository.EmpRepo;
import com.example.EmployeeSystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;

    @Autowired
    UserRepo userRepo;

    public void addEmp(Employee e ){
        repo.save(e);
    }

    public void addUser(User user ){
        userRepo.save(user);
    }


    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> e = repo.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        return null;
    }

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee employee = repo.findByEmail(username);
//        if (employee == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomEmployeeDetails(employee);
//    }

    public void deleteEmployee(int id){
        repo.deleteById(id);
    }
}
