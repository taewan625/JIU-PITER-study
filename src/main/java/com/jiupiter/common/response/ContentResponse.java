package com.jiupiter.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-06
 */
@Getter
@Setter
public class ContentResponse<T>  extends OperationResponse{ // OperationResponse를 상속 받는다. - status, message 재사용
    public ContentResponse(ResponseStatusEnum operationStatus, String operationMessage) {
        super(operationStatus, operationMessage);
        // TODO Auto-generated constructor stub
    }

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T data) {
        this.content = data;
    }

    public void setSuccessResponse(ResponseStatusEnum result, String msg, T content) {
        super.setOperationStatus(result);
        super.setOperationMessage(msg);
        this.content = content;
    }

}
