package com.emse.spring.faircorp.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration class for Spring Security, a framework for secure Java web applications.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configures the security rules for HTTP requests.
     *
     * @param http the HttpSecurity object used to configure the security rules
     * @throws Exception if an error occurs during configuration
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable Cross-Site Request Forgery (CSRF) protection and Cross-Origin Resource Sharing (CORS)
        http.cors().and().csrf().disable();

        // Set up the security rules using the authorizeRequests() and antMatchers() methods
        http.authorizeRequests()
                .antMatchers("/api/**").permitAll() // Allow all users to access the /api/** path
                .antMatchers("/").hasRole("USER")   // Allow only users with the USER role to access the / path
                .antMatchers("/api/**").hasRole("ADMIN") // Allow only users with the ADMIN role to access the /api/** path
                .and()
                .httpBasic(); // Enable HTTP Basic authentication
    }
    /**
     * Configures the authentication mechanism for the application.
     *
     * @param auth the AuthenticationManagerBuilder object used to configure the authentication mechanism
     * @throws Exception if an error occurs during configuration
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set up two users using the inMemoryAuthentication() method
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")  // user has the USER role
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN"); // admin has the USER and ADMIN roles
    }
}








