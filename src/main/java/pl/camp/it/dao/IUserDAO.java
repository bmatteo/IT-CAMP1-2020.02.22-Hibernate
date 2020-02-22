package pl.camp.it.dao;

import pl.camp.it.model.User;

import java.util.List;

public interface IUserDAO {
    void persistUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
}
