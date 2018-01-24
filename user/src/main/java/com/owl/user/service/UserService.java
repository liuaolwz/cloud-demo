package com.owl.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.owl.user.api.request.RegisterRequest;
import com.owl.user.entity.User;

public interface UserService extends IService<User> {
  User register(final RegisterRequest registerRequest);
}
