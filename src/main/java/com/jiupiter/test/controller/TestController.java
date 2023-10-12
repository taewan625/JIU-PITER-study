package com.jiupiter.test.controller;

import com.jiupiter.common.exception.OperationFailException;
import com.jiupiter.common.response.ContentResponse;
import com.jiupiter.common.response.OperationResponse;
import com.jiupiter.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-06
 */

/*
 * hardCoding으로 OperationResponse 생성자 초기화시, (OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS") 넣음
 * 4가지 종류의 test controller 수행
 *   1. view test
 *   2. OperationResponse test
 *   3. ContentResponse Success test
 *   4. ContentResponse Fail test
 * */
@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    // 기본 test 화면 - view를 보여준다.
    @GetMapping("/test")
    public String view(){
        OperationResponse res = new OperationResponse(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        return "test";
    }

    /* ResponseEntity<OperationResponse>
     * OperationResponse 객체 생성 후 http 응답으로 반환.
     * 반환시, springboot는 해당 객체를 JSON 형식으로 직렬화하고 HTTP 본문에 담아 client에게 전송
     * 참고 블로그: https://devlog-wjdrbs96.tistory.com/182
     * */
    @GetMapping("/test/none-result")
    public ResponseEntity<OperationResponse> noneResult(){
        OperationResponse res = new OperationResponse(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/test/result")
    public ResponseEntity<OperationResponse> ressult(){
        ContentResponse<String> res = new ContentResponse<>(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        // test가 success 일 경우
        res.setContent(testService.test()); // testService.test() == "테스트 성공"
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/test/error")
    public ResponseEntity<OperationResponse> error() throws OperationFailException { // 예외 처리
        ContentResponse<String> res = new ContentResponse<>(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        // test가 fail 일 경우
        res.setContent(testService.err()); // 예외 발생. new OperationFailException(); -> ControllerExceptionAdvice 중 해당 예외를 처리하는 method로 이동
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
