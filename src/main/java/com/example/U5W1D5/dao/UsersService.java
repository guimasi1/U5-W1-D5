package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.User;
import com.example.U5W1D5.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;

    public void save(User user) {
        usersDAO.save(user);
        System.out.println("User saved.");
    }

    public List<User> findAll() {
        return usersDAO.findAll();
    }

    public User findById(UUID uuid) throws ItemNotFoundException {
        return usersDAO.findById(uuid).orElseThrow(() -> new ItemNotFoundException(uuid));
    }
}
