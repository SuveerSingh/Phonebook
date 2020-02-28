package com.phonebook.phonebookapi.api.service.manager.impl;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookEntryResponse;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.models.responses.ListPhoneBookEntriesResponse;
import com.phonebook.phonebookapi.api.service.manager.PhonebookServiceManager;
import com.phonebook.phonebookapi.api.service.manager.data.PhonebookServiceDataManager;
import org.springframework.stereotype.Service;

@Service
public class PhonebookServiceManagerImpl implements PhonebookServiceManager {

    private final PhonebookServiceDataManager phonebookServiceDataManager;

    public PhonebookServiceManagerImpl(PhonebookServiceDataManager phonebookServiceDataManager) {
        this.phonebookServiceDataManager = phonebookServiceDataManager;
    }

    @Override
    public AddPhonebookResponse enlist(AddPhonebookRequest addPhonebookRequest) {
       return phonebookServiceDataManager.enlist(addPhonebookRequest);
    }

    @Override
    public AddPhonebookEntryResponse enlistEntry(AddPhonebookEntryRequest addPhonebookEntryRequest) {
        return phonebookServiceDataManager.enlistEntry(addPhonebookEntryRequest);
    }

    @Override
    public ListPhoneBookEntriesResponse list(ListPhonebookEntriesRequest listPhonebookEntriesRequest) {
        return phonebookServiceDataManager.list(listPhonebookEntriesRequest);
    }
}
