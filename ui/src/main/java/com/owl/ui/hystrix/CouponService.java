package com.owl.ui.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.owl.common.entity.Coupon;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class CouponService {
  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "fallbackCoupon")
  public List<Coupon> listCoupon() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.ALL);
    HttpEntity httpEntity = new HttpEntity(headers);
    ParameterizedTypeReference<List<Coupon>> type = new ParameterizedTypeReference<List<Coupon>>() {
    };
    return restTemplate.exchange("http://coupon/owl-coupon/api/coupon", HttpMethod.GET, httpEntity, type).getBody();
  }
  public void fallbackCoupon(){
    log.error("coupon 服务异常！");
  }
}
