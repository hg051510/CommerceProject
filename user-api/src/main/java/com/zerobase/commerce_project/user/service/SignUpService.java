package com.zerobase.commerce_project.user.service;

import com.zerobase.commerce_project.user.domain.form.SignUpForm;
import com.zerobase.commerce_project.user.domain.model.User;
import com.zerobase.commerce_project.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;

    public User signUp(SignUpForm form){
        return userRepository.save(User.from(form));
    }
}
