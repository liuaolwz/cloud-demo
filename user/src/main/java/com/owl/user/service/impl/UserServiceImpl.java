package com.owl.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.owl.common.entity.Coupon;
import com.owl.common.entity.User;
import com.owl.user.api.request.RegisterRequest;
import com.owl.user.repository.UserRepository;
import com.owl.user.service.CouponService;
import com.owl.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {
    private final CouponService couponService;
    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(CouponService couponService, RestTemplate restTemplate) {
        this.couponService = couponService;
        this.restTemplate = restTemplate;
    }

    @Override
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        BeanUtils.copyProperties(registerRequest, user);
        user.setCreateDate(LocalDateTime.now());
        baseMapper.insert(user);
        log.info("用户注册成功！");
        couponService.send(Coupon.builder().userId(user.getId()).value(BigDecimal.TEN).build());
        return user;
    }

}
