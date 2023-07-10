package com.zerobase.commerceproject.user.controller;

import com.zerobase.commerceproject.user.application.SignInApplication;
import com.zerobase.commerceproject.user.domain.form.SignInForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/signin")
@RequiredArgsConstructor
public class SignInController {

  private final SignInApplication signInApplication;

  @PostMapping
  public ResponseEntity<String> signInUser(@RequestBody SignInForm form) {
    return ResponseEntity.ok(signInApplication.userLoginToken(form));
  }

}
