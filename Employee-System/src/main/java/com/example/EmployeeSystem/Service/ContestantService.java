package com.example.EmployeeSystem.Service;

import com.example.EmployeeSystem.Entity.Contestant;
import com.example.EmployeeSystem.Repository.ContestantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContestantService {

    @Autowired
    private ContestantRepo repo;

    public void addContestant(Contestant contestant) {

        repo.save(contestant);

    }

        public List<Contestant> getAllContestants () {
            return repo.findAll();
        }


        public Contestant getContestantById ( int id){
            Optional<Contestant> c = repo.findById(id);
            if (c.isPresent()) {
                return c.get();
            }
            return null;
        }

        public void deleteContestant ( int id){
            repo.deleteById(id);
        }

    }

