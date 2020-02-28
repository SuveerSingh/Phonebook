package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;

@Getter
public class AddPhonebookEntryRequest {
    public String phonebookDescription;
    public String description;
    private String phoneNumber;
}
