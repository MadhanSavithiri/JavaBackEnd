package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList();
    String var = "Thiru";
    User ob1 = new User();
    // CREATE - Add a new user
    @PostMapping
    public String addUser(@RequestBody User userdata1) {

        users.add(userdata1);
            return "User added!";
    }

    // READ - Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // READ - Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE - Update user by ID
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                return "User updated!";
            }
        }
        return "User not found!";
    }

    // DELETE - Delete user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        users.removeIf(user -> user.getId() == id);
        return "User deleted!";
    }
}
