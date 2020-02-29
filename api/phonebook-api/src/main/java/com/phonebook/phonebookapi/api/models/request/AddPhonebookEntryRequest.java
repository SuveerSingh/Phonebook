package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddPhonebookEntryRequest {
    public String phonebookDescription;
    public String description;
    private String phoneNumber;

    public AddPhonebookEntryRequest(String phonebookDescription,
                                    String description,
                                    String phoneNumber){
        this.phonebookDescription = phonebookDescription;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }
}
