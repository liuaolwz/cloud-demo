package com.owl.ui.clients;

import com.owl.common.entity.User;
import com.owl.ui.request.RegisterRequest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient
public interface UserClient {

  @RequestMapping(value = "",method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  User save(@RequestBody RegisterRequest registerRequest);
}
