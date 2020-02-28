package com.phonebook.phonebookapi.api.service.manager.data.impl;

import com.phonebook.phonebookapi.api.models.helpers.ErrorResponses;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookEntryResponse;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.models.responses.ListPhoneBookEntriesResponse;
import com.phonebook.phonebookapi.api.service.manager.data.PhonebookServiceDataManager;
import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBook;
import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBookEntry;
import com.phonebook.phonebookapi.api.service.manager.data.repository.PhonebookEntryRepository;
import com.phonebook.phonebookapi.api.service.manager.data.repository.PhonebookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PhonebookServiceDataManagerImpl implements PhonebookServiceDataManager {

    private final PhonebookRepository phonebookRepository;
    private final PhonebookEntryRepository phonebookEntryRepository;

    public PhonebookServiceDataManagerImpl(PhonebookRepository phonebookRepository,
                                           PhonebookEntryRepository phonebookEntryRepository) {
        this.phonebookRepository = phonebookRepository;
        this.phonebookEntryRepository = phonebookEntryRepository;
    }

    @Override
    public AddPhonebookResponse enlist(AddPhonebookRequest addPhonebookRequest) {

        PhoneBook phonebook = new PhoneBook();
        phonebook.setDescription(addPhonebookRequest.getDescription());

        phonebookRepository.save(phonebook);

        return new AddPhonebookResponse(true);
    }

    @Override
    public AddPhonebookEntryResponse enlistEntry(AddPhonebookEntryRequest addPhonebookEntryRequest) {

        PhoneBook phonebook = phonebookRepository.findByDescription(addPhonebookEntryRequest.getPhonebookDescription());

        if (phonebook == null) {
            return new AddPhonebookEntryResponse(ErrorResponses.UNABLE_TO_CREATE_PHONEBOOK.getErrorCode(),
                    ErrorResponses.UNABLE_TO_CREATE_PHONEBOOK.getDescription());
        }

        PhoneBookEntry phonebookEntry = new PhoneBookEntry();

        phonebookEntry.setDescription(addPhonebookEntryRequest.getDescription());
        phonebookEntry.setPhoneNumber(addPhonebookEntryRequest.getPhoneNumber());
        phonebookEntry.setPhonebook(phonebook);

        phonebookEntryRepository.save(phonebookEntry);

        return new AddPhonebookEntryResponse(true);
    }

    @Override
    public ListPhoneBookEntriesResponse list(ListPhonebookEntriesRequest listPhonebookEntriesRequest) {

        Iterable<PhoneBookEntry> phoneBookEntries = phonebookEntryRepository.findAll();

        ListPhoneBookEntriesResponse listPhoneBookEntriesResponse = new ListPhoneBookEntriesResponse();
        listPhoneBookEntriesResponse.phoneBookEntryList = new ArrayList<>();

        for (PhoneBookEntry pbe : phoneBookEntries) {
            PhoneBookEntry phoneBookEntry = new PhoneBookEntry();
            phoneBookEntry.setId(pbe.getId());
            phoneBookEntry.setDescription(pbe.getDescription());
            phoneBookEntry.setPhoneNumber(pbe.getPhoneNumber());

            listPhoneBookEntriesResponse.phoneBookEntryList.add(phoneBookEntry);
        }

        return listPhoneBookEntriesResponse;

    }
}
