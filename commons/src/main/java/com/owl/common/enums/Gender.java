package com.owl.common.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Gender implements IEnum {
  MALE(0, "男"),
  FEMALE(1, "女");
  Gender(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
  }
  private Integer value;
  private String desc;

  @Override
  public Serializable getValue() {
    return this.value;
  }
  @JsonValue
  public String getDesc() {
    return desc;
  }
}
