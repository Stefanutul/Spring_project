//package com.example.EmployeeSystem.Details;
//
//import java.util.Collection;
//
//import com.example.EmployeeSystem.Entity.Employee;
//import com.example.EmployeeSystem.Entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class CustomEmployeeDetails implements UserDetails {
//
//    private Employee employee;
//
//    public CustomEmployeeDetails(Employee employee) {
//        this.employee = employee;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return employee.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return employee.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public String getFullName() {
//        return employee.getName();
//    }
//
//
//
//}