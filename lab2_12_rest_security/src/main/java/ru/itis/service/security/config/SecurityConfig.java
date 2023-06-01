package ru.itis.service.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.itis.service.security.filter.TokenAuthenticationFilter;
import ru.itis.service.security.providers.TokenAuthenticationProvider;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * 01.07.2020
 * 43. Spring Boot Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    @Autowired
    private TokenAuthenticationProvider tokenAuthenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenAuthenticationProvider authenticationProvider() {
        return tokenAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.formLogin().disable();
        http.logout().disable();
        http.addFilterBefore(tokenAuthenticationFilter, BasicAuthenticationFilter.class);
//        http.authorizeRequests()
//                .antMatchers("/courses/**").hasAuthority("ADMIN")
//                .antMatchers("/disciplines/**").hasAuthority("USER");
        http.headers().frameOptions().disable();

        return http.build();
    }
}
