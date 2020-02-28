package com.phonebook.phonebookapi.api.service.manager.data;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;

public interface PhonebookServiceDataManager {

    AddPhonebookResponse enlist(AddPhonebookRequest addPhonebookRequest);
}
