package by.tryput.services;


import by.tryput.entity.Role;
import by.tryput.entity.User;
import by.tryput.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {



    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       by.tryput.entity.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exist!");
        }
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), generateAuthorities(user.getRole()));
    }


    private Collection<? extends GrantedAuthority> generateAuthorities(Role role) {
        List<SimpleGrantedAuthority> result = new ArrayList<>();
         result.add(new SimpleGrantedAuthority(role.toString()));
        return result;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
