package com.jiupiter.advice;

import com.jiupiter.common.exception.OperationFailException;
import com.jiupiter.common.response.OperationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-06
 */

// Controller에서 OperationFailException 예외가 발생할 때 예외를 캐치하고, 클라이언트에게 적절한 오류 응답을 제공하는 역할
@Slf4j
@ControllerAdvice // @Controller 어노테이션이 있는 모든 곳에서의 예외 처리
public class ControllerExceptionAdvice {

    @ExceptionHandler(value = OperationFailException.class)  // @ExceptionHandler: 등록된 해당 Controller, RestController 에서만 적용
    protected ResponseEntity<OperationResponse> callSpFailureException(OperationFailException e) {
        log.error("Oeration Fail");
        OperationResponse resp = new OperationResponse(OperationResponse.ResponseStatusEnum.ERROR, "ERROR");
        resp.setOperationMessage(e.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.OK); // Network의 header에 나타나는 status
    }
}

/* 참고블로그
 *  https://jeong-pro.tistory.com/195
 *
 * */