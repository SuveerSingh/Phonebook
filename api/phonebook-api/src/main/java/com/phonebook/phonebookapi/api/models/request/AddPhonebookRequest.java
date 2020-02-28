package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;

@Getter
public class AddPhonebookRequest {
    public String userId;
    public String description;
}
