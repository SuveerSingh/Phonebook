package com.phonebook.phonebookapi.api.models.request;

import lombok.Getter;

@Getter
public class ListPhonebookRequest {
    public Integer userId;

    public ListPhonebookRequest(Integer userId,
                                       Integer phonebookId){
        this.userId = userId;
    }
}
