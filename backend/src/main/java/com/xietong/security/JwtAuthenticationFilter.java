package com.xietong.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xietong.constant.enums.ErrorCodeEnum;
import com.xietong.model.dto.ResponseDTO;
import com.xietong.utils.JWTUtils;
import com.xietong.utils.MyException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Sunforge
 * @Date 2021-06-04 18:11
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    UserDetailServiceImpl userDetailService;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwt =  request.getHeader(jwtUtils.getHeader());
        if(!StringUtils.hasText(jwt)){
            chain.doFilter(request, response);
            return;
        }
        Claims claim = jwtUtils.getClaimByToken(jwt);
        if(claim == null){
            response.setContentType("application/json;charset=UTF-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ServletOutputStream outputStream = response.getOutputStream();

            ResponseDTO responseDTO = ResponseDTO.fail(ErrorCodeEnum.JWT_ERROR, null);
            ObjectMapper mapper = new ObjectMapper();
            outputStream.write(mapper.writeValueAsString(responseDTO).getBytes("UTF-8"));

            outputStream.flush();
            outputStream.close();

//            throw new MyException(ErrorCodeEnum.JWT_ERROR, "token 异常");
        }
        if(jwtUtils.isTokenExpired(claim)){
            response.setContentType("application/json;charset=UTF-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ServletOutputStream outputStream = response.getOutputStream();

            ResponseDTO responseDTO = ResponseDTO.fail(ErrorCodeEnum.JWT_EXPIRE,null);
            ObjectMapper mapper = new ObjectMapper();
            outputStream.write(mapper.writeValueAsString(responseDTO).getBytes("UTF-8"));

            outputStream.flush();
            outputStream.close();
//            throw new MyException(ErrorCodeEnum.JWT_ERROR, "token 过期");
        }
        String username = claim.getSubject();  // username 就是userId
        // 获取用户的权限等信息

        UsernamePasswordAuthenticationToken token
//                = new UsernamePasswordAuthenticationToken(username, null, null);
                = new UsernamePasswordAuthenticationToken(username, null, userDetailService.getUserAuthority(username));

        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }


}
