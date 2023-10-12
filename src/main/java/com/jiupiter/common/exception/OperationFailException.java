package com.jiupiter.common.exception;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-06
 */

public class OperationFailException extends Exception{

    private static final long serialVersionUID = -4326310574490320048L;
    public OperationFailException() {
        super("operation fail");
    }

    public OperationFailException(final String msg) {
        super(msg);
    }

}
