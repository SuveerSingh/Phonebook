package com.phonebook.phonebookapi.api.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateRequestBodyResponses extends BaseResponse{
    public boolean status;

    public ValidateRequestBodyResponses(Boolean status){
        this.status = status;
    }

    public ValidateRequestBodyResponses(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
