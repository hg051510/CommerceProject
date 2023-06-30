package com.zerobase.commerceproject.user.domain.repository;

import com.zerobase.commerceproject.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
