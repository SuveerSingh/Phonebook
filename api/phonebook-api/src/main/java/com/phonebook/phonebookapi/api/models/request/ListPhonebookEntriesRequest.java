package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListPhonebookEntriesRequest {
    public Integer userId;
    public Integer phonebookId;

    public ListPhonebookEntriesRequest(Integer userId,
                                       Integer phonebookId){
        this.userId = userId;
        this.phonebookId = phonebookId;
    }
}
