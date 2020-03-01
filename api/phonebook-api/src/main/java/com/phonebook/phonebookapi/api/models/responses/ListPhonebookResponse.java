package com.phonebook.phonebookapi.api.models.responses;

import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBook;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ListPhonebookResponse extends BaseResponse {
    public List<PhoneBook> phoneBookList;

    public ListPhonebookResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
