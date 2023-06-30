package com.zerobase.commerceproject.user.config.filter;

import com.zerobase.commerceproject.user.service.UserService;
import com.zerobase.core.config.JwtAuthenticationProvider;
import com.zerobase.core.domain.UserVo;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@WebFilter(urlPatterns = "/user/*")
@RequiredArgsConstructor
public class CustomFilter implements Filter {

  private final JwtAuthenticationProvider jwtAuthenticationProvider;
  private final UserService userService;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    String token = req.getHeader("X-AUTH-TOKEN");
    if (!jwtAuthenticationProvider.validDateToken(token)) {
      throw new ServletException("Invalid Access");
    }
    UserVo vo = jwtAuthenticationProvider.getUserVo(token);
    userService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
        () -> new ServletException("Invalid Access")
    );
    chain.doFilter(request, response);
  }

}
