package com.thollands.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.thollands.app.ws.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
  private final UserService userDetailsService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public WebSecurity(
      UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userDetailsService = userDetailsService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Allows all POST requests to "/users" and any other request types will need
    // authentication.
    http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
        .permitAll()
        .anyRequest()
        .authenticated().and().addFilter(new AuthenticationFilter(authenticationManager()));
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    // Setting up AuthenticationManagerBuilder comes from the Spring Security Package:
    //  - The userDetailsService interface will be used
    //  - Setting an encryption method that will be used to protect the User's Password
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
  }
}
