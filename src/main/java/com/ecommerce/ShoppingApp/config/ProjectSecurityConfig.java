package com.ecommerce.ShoppingApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig  {

    /**
     * From Spring Security 5.7, the WebSecurityConfigurerAdapter is deprecated to encourage users
     * to move towards a component-based security configuration. It is recommended to create a bean
     * of type SecurityFilterChain for security related configurations.
     * @param http
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

            http.csrf().disable() 
                .authorizeHttpRequests()
                .requestMatchers("/addProduct").authenticated()
                .requestMatchers("/orders").authenticated()
                .requestMatchers("/updateProduct/**").authenticated()
                .requestMatchers("/addProductDBPlus/**").authenticated()
                .requestMatchers("/addProductDBMinus/**").authenticated()
                .requestMatchers("/deleteProduct/**").authenticated()
                .requestMatchers("/logout").authenticated()
                .requestMatchers("/addProductDB/**").authenticated()
                .requestMatchers("/").permitAll()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/products").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();

            return http.build();
    }

 }