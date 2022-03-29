package com.example.EmployeeSystem.Service;

import com.example.EmployeeSystem.Entity.Contestant;
import com.example.EmployeeSystem.Entity.User;
import com.example.EmployeeSystem.Repository.UserRepo;
import com.example.EmployeeSystem.Details.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public User getUserById ( int id){
        Optional<User> u = userRepo.findById(id);
        if (u.isPresent()) {
            return u.get();
        }
        return null;
    }

    public void addUser(User user) {

        userRepo.save(user);

    }

    public void addDescription(User user){
        user.setDescription(user.getDescription());
    }

    public List<User> getAllContestants () {
        return userRepo.findAll();
    }

    public void deleteUser ( int id){
        userRepo.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    
}