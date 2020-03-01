package com.phonebook.phonebookapi.api.service.manager.data;

import com.phonebook.phonebookapi.api.models.request.*;
import com.phonebook.phonebookapi.api.models.responses.*;

public interface PhonebookServiceDataManager {

    AddPhonebookResponse enlist(AddPhonebookRequest addPhonebookRequest);
    ListPhonebookResponse listPhonebooks (ListPhonebookRequest listPhonebookRequest);
    AddPhonebookEntryResponse enlistEntry(AddPhonebookEntryRequest addPhonebookEntryRequest);
    ListPhoneBookEntriesResponse listEntries (ListPhonebookEntriesRequest listPhonebookEntriesRequest);
    UpdatePhonebookEntryResponse updateEntry(UpdatePhonebookEntryRequest updatePhonebookEntryRequest);
}
