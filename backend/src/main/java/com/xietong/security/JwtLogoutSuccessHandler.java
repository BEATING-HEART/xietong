package com.xietong.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Sunforge
 * @Date 2021-06-10 15:45
 */
@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    JWTUtils jwtUtils;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();

        response.setHeader(jwtUtils.getHeader(), "");

        ResponseDTO result = ResponseDTO.success(null);
        ObjectMapper mapper = new ObjectMapper();
//        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));
        String responseJson = mapper.writeValueAsString(result);
        outputStream.write(responseJson.getBytes("UTF-8"));

        outputStream.flush();
        outputStream.close();
    }
}
