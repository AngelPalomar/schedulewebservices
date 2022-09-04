package com.example.schedulewebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedulewebservices.dao.UserDao;
import com.example.schedulewebservices.models.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("")
    public List<User> get() {
        return userDao.findAll();
    }

    @GetMapping("/{user_name}")
    public User getByUser_Name(@PathVariable String user_name) {
        return userDao.findByName(user_name);
    }

    @PostMapping("")
    public ResponseEntity<User> post(@RequestBody User user) {
        try {
            User newUser = userDao.save(user);
            return new ResponseEntity<User>(newUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{user_name}")
    public ResponseEntity<User> put(@PathVariable String user_name, @RequestBody User user) {
        User userStored = userDao.findByName(user_name);
        if (userStored != null) {
            try {
                userStored.setActive(user.getActive());
                userStored.setDisplayName(user.getDisplayName());
                userStored.setName(user.getName());
                userStored.setPassword(user.getPassword());
                userStored.setType(user.getType());

                userDao.save(userStored);

                return new ResponseEntity<User>(userStored, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{user_name}")
    public ResponseEntity<User> delete(@PathVariable String user_name) {
        User userStored = userDao.findByName(user_name);
        if (userStored != null) {
            try {
                userDao.delete(userStored);
                return new ResponseEntity<User>(userStored, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
