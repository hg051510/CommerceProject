package com.zerobase.commerceproject.user.service;

import com.zerobase.commerceproject.user.domain.form.SignUpForm;
import com.zerobase.commerceproject.user.domain.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SignUpServiceTest {

  @Autowired
  private SignUpService service;

  @Test
  void signUp() {
    // given
    SignUpForm form = SignUpForm.builder()
        .name("name")
        .email("test@test.com")
        .password("1234")
        .nickname("테스트")
        .birth(LocalDate.now())
        .role("구매자")
        .build();
    // when
    User user = service.signUp(form);

    // then
    assertNotNull(user.getId());
    assertNotNull(user.getCreatedAt());
  }

}