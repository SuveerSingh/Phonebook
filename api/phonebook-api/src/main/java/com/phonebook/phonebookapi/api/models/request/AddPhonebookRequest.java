package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddPhonebookRequest {
    public String userId;
    public String description;

    public AddPhonebookRequest(String userId, String description) {
        this.userId = userId;
        this.description = description;
    }
}
