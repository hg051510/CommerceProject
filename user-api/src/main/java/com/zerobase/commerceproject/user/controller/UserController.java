package com.zerobase.commerceproject.user.controller;

import com.zerobase.commerceproject.user.domain.dto.UserDto;
import com.zerobase.commerceproject.user.domain.model.User;
import com.zerobase.commerceproject.user.exception.CustomException;
import com.zerobase.commerceproject.user.exception.ErrorCode;
import com.zerobase.commerceproject.user.service.UserService;
import com.zerobase.core.config.JwtAuthenticationProvider;
import com.zerobase.core.domain.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final JwtAuthenticationProvider provider;
  private final UserService userService;

  @GetMapping("/getInfo")
  public ResponseEntity<UserDto> getInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token) {
    UserVo vo = provider.getUserVo(token);
    User u = userService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
        () -> new CustomException(ErrorCode.NOT_FOUNT_USER));
    return ResponseEntity.ok(UserDto.from(u));
  }

}
