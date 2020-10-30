package com.thollands.app.ws.service;

import com.thollands.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/*
UserDetialService interface is the core interface which loads user-specific data
 */

public interface UserService extends UserDetailsService {
  UserDto createUser(UserDto user);
}
