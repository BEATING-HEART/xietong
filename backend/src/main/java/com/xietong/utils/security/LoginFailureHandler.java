package com.xietong.utils.security;

import com.baomidou.mybatisplus.extension.api.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xietong.constant.enums.ErrorCode;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import org.apache.ibatis.jdbc.Null;
import org.springframework.context.annotation.Bean;
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
        ResponseDTO result = new ResponseDTO(ErrorCodeEnum.UNSPECIFIED, null);
        String responseJson = mapper.writeValueAsString(result);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(responseJson.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
