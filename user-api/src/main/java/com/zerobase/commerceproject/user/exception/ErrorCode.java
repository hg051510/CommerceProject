package com.zerobase.commerceproject.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
  NOT_FOUNT_USER(HttpStatus.BAD_REQUEST, "일치하는 회원이 없습니다."),
  ALREADY_VERIFY(HttpStatus.BAD_REQUEST, "이미 이메일 인증이 완료된 회원입니다."),
  WRONG_VERIFICATION(HttpStatus.BAD_REQUEST, "잘못된 인증코드 입니다."),
  EXPIRED_CODE(HttpStatus.BAD_REQUEST, "인증시간이 만료되었습니다."),
  ALREADY_REGISTERED_EMAIL(HttpStatus.BAD_REQUEST, "이미 등록된 이메일입니다."),
  ALREADY_REGISTERED_NICKNAME(HttpStatus.BAD_REQUEST, "이미 등록된 닉네임입니다.")
  ;

  private final HttpStatus httpStatus;
  private final String detail;
}
