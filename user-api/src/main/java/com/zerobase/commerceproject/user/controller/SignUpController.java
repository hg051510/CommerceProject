package com.zerobase.commerceproject.user.controller;

import com.zerobase.commerceproject.user.application.SignUpApplication;
import com.zerobase.commerceproject.user.domain.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {
  private final SignUpApplication signUpApplication;

  @PostMapping
  public ResponseEntity<String> userSignUp(@RequestBody SignUpForm form){
    return ResponseEntity.ok(signUpApplication.userSignUp(form));
  }

  @PutMapping("/verify/user")
  public ResponseEntity<String> verifyUser(String email, String code){
    signUpApplication.userVerify(email, code);
    return ResponseEntity.ok("인증이 완료되었습니다.");
  }

}
