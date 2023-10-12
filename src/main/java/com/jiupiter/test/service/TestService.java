package com.jiupiter.test.service;

import com.jiupiter.common.exception.OperationFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-06
 */
@Service
@RequiredArgsConstructor
public class TestService {

    public String test(){
        return "테스트 성공";
    }

    public String err() throws OperationFailException {
        if (1==1) throw new OperationFailException();
        return "테스트 성공";
    }
}
