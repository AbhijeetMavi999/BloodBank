//package com.user.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable().authorizeHttpRequests(auth -> {
//            auth.antMatchers("/user/register").hasRole("user");
//            auth.antMatchers("/user/{email}/{password}").hasRole("user");
//            auth.antMatchers("/user/checkblood/{state}/{bloodGroup}").hasRole("user");
//            auth.antMatchers("/user/all").hasRole("admin");
//            auth.anyRequest().authenticated();
//        }).httpBasic(Customizer.withDefaults()) .build();
//    }
//
//
//    @Bean
//    InMemoryUserDetailsManager users()
//    {
//        return new InMemoryUserDetailsManager(
//                User
//                        .withUsername("rohan")
//                        .password("{noop}rohan")
//                        .roles("user")
//                        .build(),
//                User.withUsername("abhijeet")
//                        .password("{noop}password")
//                        .roles("admin")
//                        .build());
//
//    }
//}
