package com.example.U5W1D5.dao;

import com.example.U5W1D5.entities.Desk;
import com.example.U5W1D5.entities.Reservation;
import com.example.U5W1D5.entities.User;
import com.example.U5W1D5.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public void findByIdAndDelete(UUID uuid) {
        User found = this.findById(uuid);
        usersDAO.delete(found);
        System.out.println("User deleted");
    }
    public User findByUsername(String username) {
        return usersDAO.findByUsername(username);
    }
    public List<User> findByName(String name) {
        return usersDAO.findByName(name);
    }
    public List<User> findByEmail(String email) {
        return usersDAO.findByEmail(email);
    }

    public void deleteAllUser() {
        List<User> users = usersDAO.findAll();
        for (int i = 0; i < users.size(); i++) {
            usersDAO.delete(users.get(i));
        }
    }
}
