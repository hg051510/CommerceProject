package com.zerobase.commerceproject.user.domain.dto;

import com.zerobase.commerceproject.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

  private Long id;
  private String email;

  public static UserDto from(User user) {
    return new UserDto(user.getId(), user.getEmail());
  }
}
