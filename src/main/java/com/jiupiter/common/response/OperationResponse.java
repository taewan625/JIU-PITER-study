package com.jiupiter.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-06
 */

// Controller 작업의 성공 유무 알려주는 RESTAPI
// 의미 있는 반환 값 없이 성공 실패 유무 및 status만 보여줌
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OperationResponse {
    public enum ResponseStatusEnum {SUCCESS, NO_DATA, INSPECTION_ERROR, ERROR, WARNING, NO_ACCESS};
    private ResponseStatusEnum  operationStatus;
    private String  operationMessage;

}
