package com.phonebook.phonebookapi.service.manager.data;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.request.UpdatePhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookEntryResponse;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.models.responses.ListPhoneBookEntriesResponse;
import com.phonebook.phonebookapi.api.models.responses.UpdatePhonebookEntryResponse;
import com.phonebook.phonebookapi.api.service.manager.data.impl.PhonebookServiceDataManagerImpl;
import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBook;
import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBookEntry;
import com.phonebook.phonebookapi.api.service.manager.data.repository.PhonebookEntryRepository;
import com.phonebook.phonebookapi.api.service.manager.data.repository.PhonebookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhonebookServiceDataManagerImplTests {

    @InjectMocks
    private PhonebookServiceDataManagerImpl phonebookServiceDataManager;

    @Mock
    private PhonebookRepository phonebookRepository;

    @Mock
    private PhonebookEntryRepository phonebookEntryRepository;

    @Test
    public void enlist() {

        final AddPhonebookResponse addPhonebookResponseMock = new AddPhonebookResponse(true);

        PhoneBook phoneBook = new PhoneBook(1, "Test");

        AddPhonebookRequest addPhonebookRequest = new AddPhonebookRequest("1", "Test");

        AddPhonebookResponse addPhonebookResponse = phonebookServiceDataManager.enlist(addPhonebookRequest);

        Assert.assertEquals(addPhonebookResponseMock.isStatus(), addPhonebookResponse.isStatus());
    }

    @Test
    public void enlistEntry() {

        AddPhonebookEntryRequest addPhonebookEntryRequest = new AddPhonebookEntryRequest(1,
                "Test",
                "Test");

        final AddPhonebookEntryResponse addPhonebookEntryResponseMock = new AddPhonebookEntryResponse(true);

        PhoneBookEntry phoneBookEntry = new PhoneBookEntry("1", "Test");

        Optional<PhoneBook> phoneBook = Optional.of(new PhoneBook(1, "Test"));

        when(
                phonebookRepository.findById(eq(addPhonebookEntryRequest.getPhonebookId()))
        ).thenReturn(phoneBook);

        AddPhonebookEntryResponse addPhonebookEntryResponse = phonebookServiceDataManager.enlistEntry(addPhonebookEntryRequest);

        Assert.assertEquals(addPhonebookEntryResponseMock.isStatus(), addPhonebookEntryResponse.isStatus());
    }

    @Test
    public void list() {

        ListPhonebookEntriesRequest listPhonebookEntriesRequest = new ListPhonebookEntriesRequest(1, 1);

        final ListPhoneBookEntriesResponse listPhoneBookEntriesResponseMock = new ListPhoneBookEntriesResponse();
        listPhoneBookEntriesResponseMock.phoneBookEntryList = new ArrayList<>();

        PhoneBookEntry phoneBookEntry = new PhoneBookEntry("1", "Test");

        PhoneBook phoneBook = new PhoneBook(1, "Test");

        when(
                phonebookRepository.findById(eq(listPhonebookEntriesRequest.getPhonebookId()))
        ).thenReturn(Optional.of(phoneBook));

        ListPhoneBookEntriesResponse listPhoneBookEntriesResponse = phonebookServiceDataManager.listEntries(listPhonebookEntriesRequest);

        Assert.assertEquals(listPhoneBookEntriesResponseMock.getPhoneBookEntryList().isEmpty(),
                listPhoneBookEntriesResponse.getPhoneBookEntryList().isEmpty());
    }

    @Test
    public void update() {

        UpdatePhonebookEntryRequest updatePhonebookEntryRequest = new UpdatePhonebookEntryRequest(1, "Test", "Test");

        final UpdatePhonebookEntryResponse updatePhonebookEntryResponseMock = new UpdatePhonebookEntryResponse(true);

        PhoneBookEntry phoneBookEntry = new PhoneBookEntry("1", "Test");

        when(
                phonebookEntryRepository.findById(eq(updatePhonebookEntryRequest.getPhonebookEntryId()))
        ).thenReturn(Optional.of(phoneBookEntry));

//        when(
//                phonebookEntryRepository.updateDescriptionAndPhoneNumberById(eq(updatePhonebookEntryRequest.getPhonebookEntryId()),
//                        eq(updatePhonebookEntryRequest.getDescription()),
//                        eq(updatePhonebookEntryRequest.getPhoneNumber()))
//        ).thenReturn(phoneBookEntry);

        UpdatePhonebookEntryResponse updatePhonebookEntryResponse = phonebookServiceDataManager.updateEntry(updatePhonebookEntryRequest);

        Assert.assertEquals(updatePhonebookEntryResponseMock.isStatus(),
                updatePhonebookEntryResponse.isStatus());
    }

}
