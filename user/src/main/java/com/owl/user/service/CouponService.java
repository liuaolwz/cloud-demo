package com.owl.user.service;

import com.owl.common.entity.Coupon;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Service
@FeignClient(name = "coupon",url = "${owl.zuul}/${owl.remote.coupon}")
public interface CouponService {
    @PostMapping
    Coupon send(@RequestBody Coupon coupon);
}
