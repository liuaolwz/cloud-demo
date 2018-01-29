package com.owl.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.owl.common.entity.User;
import com.owl.user.api.request.RegisterRequest;

public interface UserService extends IService<User> {
  User register(final RegisterRequest registerRequest);
}
