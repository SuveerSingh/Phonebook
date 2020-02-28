package com.phonebook.phonebookapi.api.models.responses;

import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBookEntry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListPhoneBookEntriesResponse extends BaseResponse {

    public List<PhoneBookEntry> phoneBookEntryList;

    public ListPhoneBookEntriesResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
