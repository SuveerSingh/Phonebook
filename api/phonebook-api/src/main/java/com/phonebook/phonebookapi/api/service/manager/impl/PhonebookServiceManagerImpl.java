package com.phonebook.phonebookapi.api.service.manager.impl;

import com.phonebook.phonebookapi.api.models.request.*;
import com.phonebook.phonebookapi.api.models.responses.*;
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
        AddPhonebookResponse response = phonebookServiceDataManager.enlist(addPhonebookRequest);
        return response;
    }

    @Override
    public ListPhonebookResponse listPhonebooks(ListPhonebookRequest listPhonebookRequest) {
        return phonebookServiceDataManager.listPhonebooks(listPhonebookRequest);
    }

    @Override
    public AddPhonebookEntryResponse enlistEntry(AddPhonebookEntryRequest addPhonebookEntryRequest) {
        return phonebookServiceDataManager.enlistEntry(addPhonebookEntryRequest);
    }

    @Override
    public ListPhoneBookEntriesResponse listEntries(ListPhonebookEntriesRequest listPhonebookEntriesRequest) {
        return phonebookServiceDataManager.listEntries(listPhonebookEntriesRequest);
    }

    @Override
    public UpdatePhonebookEntryResponse updateEntry(UpdatePhonebookEntryRequest updatePhonebookEntryRequest) {
        return phonebookServiceDataManager.updateEntry(updatePhonebookEntryRequest);
    }
}
