package pl.camp.it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.camp.it.model.User;
import pl.camp.it.services.IUserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping(value = "/users")
    public String users() {
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user.getLogin());
        }
        return "users";
    }

    @GetMapping(value = "/g200")
    public String g200() {
        User user = new User();
        user.setLogin("mateusz");
        user.setPass("mateusz");

        userService.persistUser(user);

        System.out.println(user.getId());

        return "redirect:/users";
    }
}
