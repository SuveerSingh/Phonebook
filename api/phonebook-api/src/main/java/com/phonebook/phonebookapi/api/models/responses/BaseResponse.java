package com.phonebook.phonebookapi.api.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    public String errorCode;
    public String errorMessage;
}
