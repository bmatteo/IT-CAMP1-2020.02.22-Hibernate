package pl.camp.it.services;

import pl.camp.it.model.User;

import java.util.List;

public interface IUserService {
    void persistUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
}
