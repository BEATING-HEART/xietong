package com.xietong.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
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
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        // 可加错误信息*************************
        System.out.println(e);
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        e.printStackTrace();
        System.out.println(e.getMessage());
        ResponseDTO result = ResponseDTO.fail(ErrorCodeEnum.UNSPECIFIED, "用户名或密码错误");
        String responseJson = mapper.writeValueAsString(result);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(responseJson.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
