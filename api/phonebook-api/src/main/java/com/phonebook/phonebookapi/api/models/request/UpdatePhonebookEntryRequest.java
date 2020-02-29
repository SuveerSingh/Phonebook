package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdatePhonebookEntryRequest {
    public int phonebookEntryId;
    public String description;
    public String phoneNumber;

    public UpdatePhonebookEntryRequest(int phonebookEntryId,
                                       String description,
                                       String phoneNumber){
        this.phonebookEntryId = phonebookEntryId;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }
}
