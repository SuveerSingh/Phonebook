package com.phonebook.phonebookapi.api.models.responses;

import com.phonebook.phonebookapi.api.models.request.UpdatePhonebookEntryRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
