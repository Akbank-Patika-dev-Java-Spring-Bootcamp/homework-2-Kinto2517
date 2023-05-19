package com.kinto2517.springsecondtask.Error;

import com.kinto2517.springsecondtask.Base.BaseErrorMessage;

public class CustomPersonError implements BaseErrorMessage {

    private String errorMessage;

    public CustomPersonError(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public String toString() {
        return errorMessage;
    }

}
