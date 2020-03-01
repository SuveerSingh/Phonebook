package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddPhonebookEntryRequest {
    public Integer phonebookId;
    public String description;
    private String phoneNumber;

    public AddPhonebookEntryRequest(Integer phonebookId,
                                    String description,
                                    String phoneNumber){
        this.phonebookId = phonebookId;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }
}
