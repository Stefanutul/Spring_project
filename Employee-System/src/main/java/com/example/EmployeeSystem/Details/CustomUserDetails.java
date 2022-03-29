package com.example.EmployeeSystem.Details;

import java.util.Collection;

import com.example.EmployeeSystem.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

 public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

    public String getPosition() {
         return user.getPosition();
     }

     public String getFirstName() { return user.getFirstName(); }

     public String getDescription() { return user.getDescription(); }

     public String getDepartment() {
         return user.getDepartment();
     }

     public int getSalary() {
         return user.getSalary();
     }

     public String getCity() {
         return user.getCity();
     }

     public void setDescription(){
        user.setDescription(user.getDescription());

     }








}