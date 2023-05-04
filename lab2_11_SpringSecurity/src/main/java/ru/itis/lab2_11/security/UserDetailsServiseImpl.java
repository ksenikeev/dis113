package ru.itis.lab2_11.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.lab2_11.model.security.User;
import ru.itis.lab2_11.repositoryes.UserRepository;
import ru.itis.lab2_11.repositoryes.UserRoleRepository;

import java.util.List;

@Service(value = "myUserDetailsServise")
public class UserDetailsServiseImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername " + username);
        User user = repository.findByUserName(username);
        if (user != null) {
            return new UserDetailImpl(user);
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
