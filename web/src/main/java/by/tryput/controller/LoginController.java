package by.tryput.controller;

import by.tryput.entity.FullName;
import by.tryput.entity.Role;
import by.tryput.entity.User;
import by.tryput.mappers.UserDto;
import by.tryput.repositories.UserRepository;
import by.tryput.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto user() {
        return new UserDto();
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/seances";
    }

    @GetMapping("/login/registration")
    public String registration() {
        return "register";
    }

    @PostMapping("/login/registration")
    public String confirmRegistration(@Valid UserDto user, Errors errors) {
        if(errors.hasErrors() || !user.getPassword().equals(user.getConfirmPassword())) {
            return "redirect:/login/registration";
        }
        String encode = encoder.encode(user.getPassword());
        User userToSave = new User();
        userToSave.setUsername(user.getUsername());
        userToSave.setPassword(encode);
        userToSave.setFullName(new FullName());
        userToSave.getFullName().setFirstName(user.getFirstName());
        userToSave.getFullName().setLastName(user.getLastName());
        userToSave.setEmail(user.getEmail());
        userToSave.setRole(Role.USER);
        userService.addUser(userToSave);
        if (userToSave.getId() == null) {
            return "register";
        }
        return "login";
    }

}
