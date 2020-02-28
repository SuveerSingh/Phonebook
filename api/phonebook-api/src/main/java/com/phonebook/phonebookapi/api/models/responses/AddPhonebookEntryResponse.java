package com.phonebook.phonebookapi.api.models.responses;

import lombok.Getter;

@Getter
public class AddPhonebookEntryResponse extends BaseResponse {
    public boolean status;

    public AddPhonebookEntryResponse(boolean status){
        this.status = status;
    }

    public AddPhonebookEntryResponse(String errorCode,
                                String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
