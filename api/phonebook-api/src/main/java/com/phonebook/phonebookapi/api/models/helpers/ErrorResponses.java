package com.phonebook.phonebookapi.api.models.helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorResponses {

    INVALID_REQUEST_BODY("1", "Something went wrong with your request"),
    NULL_VALUE_IN_REQUEST("1", "Invalid parameter. Cannot be null"),
    INVALID_CREDENTIALS("2", "Invalid credentials"),
    UNABLE_TO_CREATE_PHONEBOOK("3", "Failed to create phonebook"),
    UNABLE_TO_FIND_PHONEBOOK("3", "Failed to find phonebook"),
    UNABLE_TO_FIND_PHONEBOOK_ENTRY("4", "Failed to find phonebook entry"),
    UNABLE_TO_UPDATE_PHONEBOOK_ENTRY("4", "Failed to update phonebook entry"),
    ;

    private String errorCode;
    private String description;


    ErrorResponses(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
}
