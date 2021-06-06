package com.xietong.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Sunforge
 * @Date 2021-06-04 19:08
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ServletOutputStream outputStream = response.getOutputStream();

        ResponseDTO responseDTO = new ResponseDTO(ErrorCodeEnum.RQ_UNAUTHORIZED, null);
        ObjectMapper mapper = new ObjectMapper();
        outputStream.write(mapper.writeValueAsString(responseDTO).getBytes("UTF-8"));

        outputStream.flush();
        outputStream.close();
    }
}
