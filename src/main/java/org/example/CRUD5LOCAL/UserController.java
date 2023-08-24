package org.example.CRUD5LOCAL;

import java.util.List;

public class UserController {
    private UserRepository repository = new UserRepository();

    public void createUser(String name, int age, double salary) {
        User user = new User(name, age, salary);
        repository.save(user);
    }

    public User getUser(int id) {
        return repository.findById(id);
    }

    public void deleteUser(int id) {
        repository.delete(id);
    }

    public List<User> listUsers() {
        return repository.getAll();
    }
}