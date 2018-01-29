package com.owl.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.owl.common.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model{
  private Long id;
  private String name;
  private Integer age;
  private Gender gender;
  private LocalDateTime createDate;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
