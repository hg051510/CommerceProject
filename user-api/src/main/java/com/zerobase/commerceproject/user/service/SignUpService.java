package com.zerobase.commerceproject.user.service;

import com.zerobase.commerceproject.user.domain.form.SignUpForm;
import com.zerobase.commerceproject.user.domain.model.User;
import com.zerobase.commerceproject.user.domain.repository.UserRepository;
import com.zerobase.commerceproject.user.exception.CustomException;
import com.zerobase.commerceproject.user.exception.ErrorCode;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

  private final UserRepository userRepository;

  public User signUp(SignUpForm form) {
    return userRepository.save(User.from(form));
  }

  public boolean isEmailExist(String email) {
    return userRepository.findByEmail(email.toLowerCase(Locale.ROOT)).isPresent();
  }

  public boolean isNicknameExist(String nickname){
    return userRepository.findByNickname(nickname).isPresent();
  }

  @Transactional
  public void verifyEmail(String email, String code) {
    User user = userRepository.findByEmail(email.toLowerCase(Locale.ROOT))
        .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUNT_USER));
    if(user.isVerify()){
      throw new CustomException(ErrorCode.ALREADY_VERIFY);
    } else if (!user.getVerificationCode().equals(code)) {
      throw new CustomException(ErrorCode.WRONG_VERIFICATION);
    } else if (user.getVerifyExpiredAt().isBefore(LocalDateTime.now())) {
      throw new CustomException(ErrorCode.EXPIRED_CODE);
    }

    user.setVerify(true);
  }

  @Transactional
  public LocalDateTime changeUserValidationEmail(Long userId, String verificationCode){
    Optional<User> userOptional = userRepository.findById(userId);

    if(userOptional.isPresent()){
      User user = userOptional.get();
      user.setVerificationCode(verificationCode);
      user.setVerifyExpiredAt(LocalDateTime.now().plusDays(7));

      return user.getVerifyExpiredAt();
    }

    throw new CustomException(ErrorCode.NOT_FOUNT_USER);
  }

}
