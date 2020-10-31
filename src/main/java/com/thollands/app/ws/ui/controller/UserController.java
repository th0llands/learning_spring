package com.thollands.app.ws.ui.controller;

import com.thollands.app.ws.service.UserService;
import com.thollands.app.ws.shared.dto.UserDto;
import com.thollands.app.ws.ui.model.request.UserDetailsRequestModel;
import com.thollands.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
  Spring Web Annotation:

  @RestController means the class is ready for use by Spring MVC to handle web requests.
  It combines @Controller and @ResponseBody annotations that results in web requests returning
  data rather than a view.

  New Request Mapping Shortcuts:

  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, and @PatchMapping are different variants
  of @RequestMapping with the HTTP method already set to GET, POST, PUT, DELETE, and PATCH respectively.
*/

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

  // By declaring all the bean dependencies in a Spring configuration file, Spring container
  // can autowire relationships between collaborating beans. This is called Spring bean autowiring.
  // @Autowired eliminates the need for getters and setters
  @Autowired
  UserService userService;

  @GetMapping
  public String getUser() {
    return " get user was called";
  }

  @PostMapping
  public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
    UserRest returnValue = new UserRest();

    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userDetails, userDto);

    UserDto createdUser = userService.createUser(userDto);
    BeanUtils.copyProperties(createdUser, returnValue);

    return returnValue;
  }

  @PutMapping
  public String updateUser() {
    return "update user was called";
  }

  @DeleteMapping
  public String deleteUser() {
    return "delete user was called";
  }
}
