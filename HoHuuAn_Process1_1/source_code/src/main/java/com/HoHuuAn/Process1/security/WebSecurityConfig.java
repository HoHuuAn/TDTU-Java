package com.HoHuuAn.Process1.security;


import com.HoHuuAn.Process1.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/images/**").permitAll()
                                .requestMatchers("/delete/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/edit/**", "/new").hasAnyAuthority("ROLE_ADMIN", "ROLE_EDITOR")
                                .anyRequest().authenticated())
                .formLogin(formlogin -> formlogin
                        .loginPage("/login")
                        .failureHandler(loginFailureHandler)
                        .permitAll())
                .logout(LogoutConfigurer::permitAll)
                .rememberMe(rm ->
                        rm.tokenValiditySeconds(7 * 24 * 60 * 60) // expiration time: 7 days
                            .key("AbcdefghiJklmNoPqRstUvXyz"))  // cookies will survive if restarted
                .exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/403"));
        http.authenticationProvider(authenticationProvider());
        return http.build();
    }


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
