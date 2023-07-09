package com.zerobase.commerceproject.user.application;

import com.zerobase.commerceproject.user.client.MailgunClient;
import com.zerobase.commerceproject.user.client.mailgun.SendMailForm;
import com.zerobase.commerceproject.user.domain.form.SignUpForm;
import com.zerobase.commerceproject.user.domain.model.User;
import com.zerobase.commerceproject.user.exception.CustomException;
import com.zerobase.commerceproject.user.exception.ErrorCode;
import com.zerobase.commerceproject.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpApplication {

  private final MailgunClient mailgunClient;
  private final SignUpService signUpService;

  public void userVerify(String email, String code) {
    signUpService.verifyEmail(email, code);
  }

  public String userSignUp(SignUpForm form) {
    if (signUpService.isEmailExist(form.getEmail())) {
      throw new CustomException(ErrorCode.ALREADY_REGISTERED_EMAIL);
    } else if (signUpService.isNicknameExist(form.getNickname())) {
      throw new CustomException(ErrorCode.ALREADY_REGISTERED_NICKNAME);
    } else {
      User u = signUpService.signUp(form);

      String code = getRandomCode();
      SendMailForm sendMailForm = SendMailForm.builder()
          .from("test@zerobase.com")
          .to(form.getEmail())
          .subject("Verification Email")
          .text(getVerificationEmailBody(u.getEmail(), u.getName(), code))
          .build();
      mailgunClient.sendEmail(sendMailForm);
      signUpService.changeUserValidationEmail(u.getId(), code);
      return "회원 가입에 성공하셨습니다.";
    }
  }

  public String getRandomCode() {
    return RandomStringUtils.random(10, true, true);
  }

  public String getVerificationEmailBody(String email, String name, String code) {
    StringBuilder sb = new StringBuilder();
    return sb.append("Hello").append(name).append("! Please Click Link for verification. \n\n")
        .append("http://localhost:8081/signup/verify/?email=")
        .append(email)
        .append("&code=")
        .append(code).toString();
  }

}
