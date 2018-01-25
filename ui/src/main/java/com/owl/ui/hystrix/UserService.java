package com.owl.ui.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.owl.common.entity.User;
import com.owl.ui.clients.UserClient;
import com.owl.ui.request.RegisterRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
  @Autowired
  private UserClient userClient;

  @HystrixCommand(fallbackMethod = "fallbackUser")
  public User register(final RegisterRequest registerRequest) {
    return userClient.save(registerRequest);
  }

  public void fallbackUser() {
    log.error("用户服务异常！");
  }
}
