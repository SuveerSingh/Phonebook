package com.phonebook.phonebookapi.api.service.manager.data.impl;

import com.phonebook.phonebookapi.api.models.helpers.ErrorResponses;
import com.phonebook.phonebookapi.api.models.request.*;
import com.phonebook.phonebookapi.api.models.responses.*;
import com.phonebook.phonebookapi.api.service.manager.data.PhonebookServiceDataManager;
import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBook;
import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBookEntry;
import com.phonebook.phonebookapi.api.service.manager.data.repository.PhonebookEntryRepository;
import com.phonebook.phonebookapi.api.service.manager.data.repository.PhonebookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ListPhonebookResponse listPhonebooks(ListPhonebookRequest listPhonebookRequest) {
        Iterable<PhoneBook> phoneBookList = phonebookRepository.findAll();

        if (phoneBookList != null) {

            ListPhonebookResponse listPhonebookResponse = new ListPhonebookResponse();
            listPhonebookResponse.phoneBookList = new ArrayList<>();

            for (PhoneBook pb : phoneBookList) {
                PhoneBook phoneBook = new PhoneBook();
                phoneBook.setId(pb.getId());
                phoneBook.setDescription(pb.getDescription());


                listPhonebookResponse.phoneBookList.add(phoneBook);
            }

            return listPhonebookResponse;
        }

        return new ListPhonebookResponse(ErrorResponses.UNABLE_TO_FIND_PHONEBOOK.getErrorCode(),
                ErrorResponses.UNABLE_TO_FIND_PHONEBOOK_ENTRY.getDescription());
    }

    @Override
    public AddPhonebookEntryResponse enlistEntry(AddPhonebookEntryRequest addPhonebookEntryRequest) {

        Optional<PhoneBook> phoneBookOptional = phonebookRepository.findById(addPhonebookEntryRequest.getPhonebookId());

        if (phoneBookOptional == null) {
            return new AddPhonebookEntryResponse(ErrorResponses.UNABLE_TO_CREATE_PHONEBOOK.getErrorCode(),
                    ErrorResponses.UNABLE_TO_CREATE_PHONEBOOK.getDescription());
        }

        PhoneBook phoneBook = phoneBookOptional.get();

        PhoneBookEntry phonebookEntry = new PhoneBookEntry();

        phonebookEntry.setDescription(addPhonebookEntryRequest.getDescription());
        phonebookEntry.setPhoneNumber(addPhonebookEntryRequest.getPhoneNumber());
        phonebookEntry.setPhonebook(phoneBook);

        phonebookEntryRepository.save(phonebookEntry);

        return new AddPhonebookEntryResponse(true);
    }

    @Override
    public ListPhoneBookEntriesResponse listEntries(ListPhonebookEntriesRequest listPhonebookEntriesRequest) {
        Optional<PhoneBook> phoneBookOptional = phonebookRepository.findById(listPhonebookEntriesRequest.getPhonebookId());

        if (phoneBookOptional != null) {
            PhoneBook phoneBook = phoneBookOptional.get();

            Iterable<PhoneBookEntry> phoneBookEntries = phonebookEntryRepository.findPhonebookEntryByPhonebookId(listPhonebookEntriesRequest.getPhonebookId());

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

        return new ListPhoneBookEntriesResponse(ErrorResponses.UNABLE_TO_FIND_PHONEBOOK.getErrorCode(),
                ErrorResponses.UNABLE_TO_FIND_PHONEBOOK_ENTRY.getDescription());
    }

    @Override
    public UpdatePhonebookEntryResponse updateEntry(UpdatePhonebookEntryRequest updatePhonebookEntryRequest) {

        Optional<PhoneBookEntry> phoneBookEntryOptional = phonebookEntryRepository.findById(updatePhonebookEntryRequest.getPhonebookEntryId());

        if (phoneBookEntryOptional != null) {
            PhoneBookEntry phoneBookEntry = phoneBookEntryOptional.get();

            phoneBookEntry.setDescription(updatePhonebookEntryRequest.getDescription());
            phoneBookEntry.setPhoneNumber(updatePhonebookEntryRequest.getPhoneNumber());

            phonebookEntryRepository.updateDescriptionAndPhoneNumberById(phoneBookEntry.getId(),
                    phoneBookEntry.getDescription(),
                    phoneBookEntry.getPhoneNumber());

            return new UpdatePhonebookEntryResponse(true);
        }

        return new UpdatePhonebookEntryResponse(ErrorResponses.UNABLE_TO_FIND_PHONEBOOK_ENTRY.getErrorCode(),
                ErrorResponses.UNABLE_TO_FIND_PHONEBOOK_ENTRY.getDescription());

    }
}
