package com.phonebook.phonebookapi.api.models.helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorResponses {

    INVALID_REQUEST_BODY("1", "Something went wrong with your request"),
    INVALID_CREDENTIALS("2", "Invalid credentials"),
    UNABLE_TO_CREATE_PHONEBOOK("3", "Failed to create phonebook"),
    ;

    private String errorCode;
    private String description;


    ErrorResponses(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
}
