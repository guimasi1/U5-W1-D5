package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;

    public void save(User user) {
        usersDAO.save(user);
        System.out.println("User saved.");
    }
}
