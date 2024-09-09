package com.HoHuuAn.Process1.security;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;


@Component("authenticationFailureHandler")
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String failureUrl = "/login?error=";
        if (exception instanceof BadCredentialsException) {
            failureUrl += URLEncoder.encode("error", StandardCharsets.UTF_8);
        }
        else if (exception instanceof DisabledException) {
            failureUrl += URLEncoder.encode(exception.getMessage(), StandardCharsets.UTF_8);
        }
        else if (exception.getMessage().equals("No value present")  ) {
            failureUrl += URLEncoder.encode("inexisted", StandardCharsets.UTF_8);
        }
        System.out.println(exception.getMessage());

        UrlPathHelper helper = new UrlPathHelper();
        String contextPath = helper.getContextPath(request);

        super.setDefaultFailureUrl(contextPath + failureUrl);
        super.onAuthenticationFailure(request, response, exception);

    }
}
