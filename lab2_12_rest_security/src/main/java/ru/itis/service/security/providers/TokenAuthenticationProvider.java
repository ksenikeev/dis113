package ru.itis.service.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.service.models.User;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.security.authentication.TokenAuthentication;
import ru.itis.service.security.details.UsersDetailsImpl;

import java.util.Optional;

/**
 * 05.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("PROVIDER " + authentication.getName());
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
        Optional<User> userOptional = usersRepository.findByToken(tokenAuthentication.getName());
        if (userOptional.isPresent()) {
            UsersDetailsImpl userDetails = new UsersDetailsImpl(userOptional.get());
            tokenAuthentication.setAuthenticated(true);
            tokenAuthentication.setUserDetails(userDetails);
            return tokenAuthentication;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(TokenAuthentication.class.getName());
    }
}
