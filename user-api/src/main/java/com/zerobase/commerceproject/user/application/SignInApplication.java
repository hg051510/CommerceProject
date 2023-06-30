package com.zerobase.commerceproject.user.application;

import com.zerobase.commerceproject.user.domain.form.SignInForm;
import com.zerobase.commerceproject.user.domain.model.User;
import com.zerobase.commerceproject.user.exception.CustomException;
import com.zerobase.commerceproject.user.exception.ErrorCode;
import com.zerobase.commerceproject.user.service.UserService;
import com.zerobase.core.config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInApplication {

  private final UserService userService;
  private final JwtAuthenticationProvider provider;

  public String userLoginToken(SignInForm form) {
    User u = userService.findValidUser(form.getEmail(), form.getPassword())
        .orElseThrow(() -> new CustomException(ErrorCode.LOGIN_CHECK_FAIL));

    return provider.createToken(u.getEmail(), u.getId(), u.getType());
  }

}
