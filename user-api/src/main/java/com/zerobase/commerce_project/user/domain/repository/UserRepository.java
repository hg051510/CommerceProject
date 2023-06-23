package com.zerobase.commerce_project.user.domain.repository;

import com.zerobase.commerce_project.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
