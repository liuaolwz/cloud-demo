package com.owl.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.owl.user.api.request.RegisterRequest;
import com.owl.common.entity.User;
import com.owl.user.repository.UserRepository;
import com.owl.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {
  @Override
  public User register(RegisterRequest registerRequest) {
    User user = new User();
    BeanUtils.copyProperties(registerRequest,user);
    user.setCreateDate(LocalDateTime.now());
    baseMapper.insert(user);
    log.info("用户注册成功！");
    return user;
  }
}
