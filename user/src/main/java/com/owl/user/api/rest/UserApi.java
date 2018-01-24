package com.owl.user.api.rest;

import com.owl.user.api.request.RegisterRequest;
import com.owl.user.service.UserService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/owl-user/api/user")
public class UserApi {
  @Autowired
  private UserService userService;

  @ApiOperation(value = "注册")
  @RequestMapping(method = RequestMethod.POST)
  public String register(@Valid @RequestBody final RegisterRequest registerRequest) {
    return userService.register(registerRequest);
  }
}
