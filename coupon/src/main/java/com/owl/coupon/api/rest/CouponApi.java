package com.owl.coupon.api.rest;


import com.owl.common.entity.Coupon;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/coupon")
public class CouponApi {
  @ApiOperation(value = "发放一张红包")
  @PostMapping
  public Coupon save(@RequestBody final Coupon coupon) {
    return Coupon.builder().id(1L).userId(coupon.getUserId()).value(coupon.getValue()).build();
  }

  @ApiOperation(value = "获取用户所用红包")
  @GetMapping
  public List<Coupon> list(@RequestParam("userId") final Long userId) {
    return Arrays.asList(
        Coupon.builder().id(1L).value(BigDecimal.TEN).userId(userId).build(),
        Coupon.builder().id(2L).value(BigDecimal.valueOf(20)).userId(userId).build());
  }
}
