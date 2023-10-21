package com.omkar.usermanagement.usermanage.Config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {
@Bean
public PasswordEncoder encoder (){return new BCryptPasswordEncoder(10);
}
@Bean
public UserDetailsService userdetailsService (){
    return new CustomUserDetailsService();
}
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userdetailsService());

        daoAuthenticationProvider.setPasswordEncoder(encoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(String.valueOf(PathRequest.toStaticResources().atCommonLocations())).permitAll() // Allow access to static resources
                        .requestMatchers("/login", "/signup").permitAll() // Permit access to login and signup
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Require ADMIN role for /admin/**
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Specify the login page URL
                        .permitAll()
                );

        return http.build();
    }

}
