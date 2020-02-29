package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;

@Getter
public class UpdatePhonebookEntryRequest {
    public int phonebookEntryId;
    public String description;
    public String phoneNumber;
}
