package org.example.CRUD5LOCAL;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}