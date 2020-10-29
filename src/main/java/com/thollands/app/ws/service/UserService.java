package com.thollands.app.ws.service;

import com.thollands.app.ws.shared.dto.UserDto;

public interface UserService {
  UserDto createUser(UserDto user);
}
