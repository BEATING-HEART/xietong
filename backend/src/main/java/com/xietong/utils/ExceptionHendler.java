package com.xietong.utils;

import com.xietong.model.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Sunforge
 * @Date 2021-06-14 13:41
 */
@RestControllerAdvice
public class ExceptionHendler {


        //

        // 实体校验异常捕获
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseDTO handler(MethodArgumentNotValidException e) {

            BindingResult result = e.getBindingResult();
            ObjectError objectError = result.getAllErrors().stream().findFirst().get();

//            log.error("实体校验异常：----------------{}", objectError.getDefaultMessage());
            return ResponseDTO.fail(objectError.getDefaultMessage());
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(value = IllegalArgumentException.class)
        public ResponseDTO handler(IllegalArgumentException e) {
//            log.error("Assert异常：----------------{}", e.getMessage());
            return ResponseDTO.fail(e.getMessage());
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(value = RuntimeException.class)
        public ResponseDTO handler(RuntimeException e) {
//            log.error("运行时异常：----------------{}", e.getMessage());
            return ResponseDTO.fail(e.getMessage());
        }

}
