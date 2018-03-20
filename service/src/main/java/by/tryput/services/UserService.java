package by.tryput.services;

import by.tryput.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {

    User addUser(User user);
}
