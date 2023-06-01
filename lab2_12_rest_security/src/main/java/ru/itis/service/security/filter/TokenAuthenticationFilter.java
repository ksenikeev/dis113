package ru.itis.service.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.service.security.authentication.TokenAuthentication;
import java.io.IOException;

/**
 * 05.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component("tokenAuthenticationFilter")
public class TokenAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println("IN FILTER " + servletRequest.toString());
        // получаем токен
        String token = request.getHeader("token");
        if (token != null) {
            // создаем объект аутентификации
            Authentication authentication = new TokenAuthentication(token);
            // кладем его в контекст для текущего потока
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // отправили запрос дальше
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
