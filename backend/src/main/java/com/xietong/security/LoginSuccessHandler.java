package com.xietong.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Sunforge
 * @Date 2021-06-02 17:18
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JWTUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 返回JWT
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
//        System.out.println("123");
        String jwt = jwtUtils.generateToken(authentication.getName());
        response.setHeader(jwtUtils.getHeader(), jwt);
        ResponseDTO result = new ResponseDTO(ErrorCodeEnum.SUCCESS, "登录成功", null);
        String responseJson = mapper.writeValueAsString(result);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(responseJson.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
