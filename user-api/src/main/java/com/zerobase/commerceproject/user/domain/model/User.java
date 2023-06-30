package com.zerobase.commerceproject.user.domain.model;

import com.sun.istack.NotNull;
import com.zerobase.commerceproject.user.domain.form.SignUpForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AuditOverride(forClass = BaseEntity.class)
@Table(name = "commerce_user")
public class User extends BaseEntity {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String name;

  @NotNull
  @Column(unique = true)
  private String email;

  @NotNull
  private String password;

  @NotNull
  @Column(unique = true)
  private String nickname;

  private LocalDate birth;
  private boolean verify;

  @NotNull
  private String role;

  public static User from(SignUpForm form) {
    return User.builder()
        .name(form.getName())
        .email(form.getEmail().toLowerCase(Locale.ROOT))
        .password(form.getPassword())
        .nickname(form.getNickname())
        .birth(form.getBirth())
        .verify(false)
        .role(form.getRole())
        .build();
  }
}
