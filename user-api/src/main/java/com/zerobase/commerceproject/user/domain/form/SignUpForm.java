package com.zerobase.commerceproject.user.domain.form;

import com.zerobase.core.domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {

  private String email;
  private String name;
  private String nickname;
  private String password;
  private LocalDate birth;
  private UserType type;
}
