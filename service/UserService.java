package com.example.user.service;

import com.example.user.exception.UserNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.repository.UserRepository;
import com.example.user.domain.User;

@Service
public class UserService {

    private final UserRepository repo;
    
    @Autowired
    public UserService(UserRepository repo) {
    	this.repo = repo;
    }
	
	public List<User> findAllUsers() {
        return repo.findAll();
    }
     
	public User addUser(User user) {
		    return repo.save(user);
		    }
    public void save(User std) {
        repo.save(std);
    }
     
    public User get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public User findUserById(Long id) {
    	return repo.findUserById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("user by id" + id + " not found" ));
    }


}