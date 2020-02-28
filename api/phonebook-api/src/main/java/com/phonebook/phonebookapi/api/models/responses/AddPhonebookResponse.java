package com.phonebook.phonebookapi.api.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPhonebookResponse extends BaseResponse {

    public boolean status;

    public AddPhonebookResponse(boolean status){
        this.status = status;
    }

    public AddPhonebookResponse(String errorCode,
                                String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
