package com.phonebook.phonebookapi.service.manager;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.request.UpdatePhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookEntryResponse;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.models.responses.ListPhoneBookEntriesResponse;
import com.phonebook.phonebookapi.api.models.responses.UpdatePhonebookEntryResponse;
import com.phonebook.phonebookapi.api.service.manager.data.PhonebookServiceDataManager;
import com.phonebook.phonebookapi.api.service.manager.impl.PhonebookServiceManagerImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhonebookServiceManagerTests {

    @InjectMocks
    private PhonebookServiceManagerImpl phonebookServiceManager;

    @Mock
    private PhonebookServiceDataManager phonebookServiceDataManager;

    @Test
    public void enlist() {

        final AddPhonebookResponse addPhonebookResponseMock = new AddPhonebookResponse(true);

        AddPhonebookRequest addPhonebookRequest = new AddPhonebookRequest("1","Test");

        when(
                phonebookServiceDataManager.enlist(eq(addPhonebookRequest))
        ).thenReturn(addPhonebookResponseMock);

        AddPhonebookResponse addPhonebookResponse = phonebookServiceManager.enlist(addPhonebookRequest);

        Assert.assertEquals(addPhonebookResponseMock.isStatus(), addPhonebookResponse.isStatus());
    }

    @Test
    public void enlistEntry() {

        final AddPhonebookEntryResponse addPhonebookEntryResponseMock = new AddPhonebookEntryResponse(true);

        AddPhonebookEntryRequest addPhonebookEntryRequest = new AddPhonebookEntryRequest("1","Test", "Test");

        when(
                phonebookServiceDataManager.enlistEntry(eq(addPhonebookEntryRequest))
        ).thenReturn(addPhonebookEntryResponseMock);

        AddPhonebookEntryResponse addPhonebookEntryResponse = phonebookServiceManager.enlistEntry(addPhonebookEntryRequest);

        Assert.assertEquals(addPhonebookEntryResponseMock.isStatus(), addPhonebookEntryResponse.isStatus());
    }

    @Test
    public void list() {

        final ListPhonebookEntriesRequest listPhonebookEntriesRequest = new ListPhonebookEntriesRequest(1, 1);

        ListPhoneBookEntriesResponse listPhoneBookEntriesResponseMock = new ListPhoneBookEntriesResponse();
        listPhoneBookEntriesResponseMock.phoneBookEntryList = new ArrayList<>();

        when(
                phonebookServiceDataManager.list(eq(listPhonebookEntriesRequest))
        ).thenReturn(listPhoneBookEntriesResponseMock);

        ListPhoneBookEntriesResponse listPhoneBookEntriesResponse = phonebookServiceManager.list(listPhonebookEntriesRequest);

        Assert.assertEquals(!listPhoneBookEntriesResponseMock.phoneBookEntryList.isEmpty(), !listPhoneBookEntriesResponse.getPhoneBookEntryList().isEmpty());
    }

    @Test
    public void update() {

        final UpdatePhonebookEntryRequest updatePhonebookEntryRequest = new UpdatePhonebookEntryRequest(1, "test","test");

        UpdatePhonebookEntryResponse updatePhonebookEntryResponseMock = new UpdatePhonebookEntryResponse(true);

        when(
                phonebookServiceDataManager.updateEntry(eq(updatePhonebookEntryRequest))
        ).thenReturn(updatePhonebookEntryResponseMock);

        UpdatePhonebookEntryResponse updatePhonebookEntryResponse = phonebookServiceManager.updateEntry(updatePhonebookEntryRequest);

        Assert.assertEquals(updatePhonebookEntryResponseMock.isStatus(), updatePhonebookEntryResponse.isStatus());
    }
}
