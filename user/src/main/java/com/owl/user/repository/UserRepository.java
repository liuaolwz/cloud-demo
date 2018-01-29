package com.owl.user.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.owl.common.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseMapper<User> {

}
