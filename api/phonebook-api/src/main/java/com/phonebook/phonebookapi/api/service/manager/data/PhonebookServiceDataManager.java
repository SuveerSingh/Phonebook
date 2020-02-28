package com.phonebook.phonebookapi.api.service.manager.data;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookEntryResponse;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.models.responses.ListPhoneBookEntriesResponse;

public interface PhonebookServiceDataManager {

    AddPhonebookResponse enlist(AddPhonebookRequest addPhonebookRequest);
    AddPhonebookEntryResponse enlistEntry(AddPhonebookEntryRequest addPhonebookEntryRequest);
    ListPhoneBookEntriesResponse list (ListPhonebookEntriesRequest listPhonebookEntriesRequest);
}
