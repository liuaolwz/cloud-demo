package com.owl.ui.api;

import com.owl.common.entity.Coupon;
import com.owl.common.entity.User;
import com.owl.ui.hystrix.CouponService;
import com.owl.ui.hystrix.UserService;
import com.owl.ui.request.RegisterRequest;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UiApi {
  private final UserService userService;
  private final CouponService couponService;

  @Autowired
  public UiApi(UserService userService, CouponService couponService) {
    this.userService = userService;
    this.couponService = couponService;
  }

  @ApiOperation(value = "用户注册接口")
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public User register(@RequestBody final RegisterRequest registerRequest) {
    return userService.register(registerRequest);
  }

  @ApiOperation(value = "查询红包接口")
  @RequestMapping(value = "/coupon", method = RequestMethod.GET)
  public List<Coupon> listCoupon() {
    return couponService.listCoupon();
  }

}
