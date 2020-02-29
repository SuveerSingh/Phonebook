package com.phonebook.phonebookapi.api.models.responses;

import com.phonebook.phonebookapi.api.models.request.UpdatePhonebookEntryRequest;

public class UpdatePhonebookEntryResponse extends BaseResponse {

    public boolean status;

    public UpdatePhonebookEntryResponse(boolean status){
        this.status = status;
    }

    public UpdatePhonebookEntryResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
