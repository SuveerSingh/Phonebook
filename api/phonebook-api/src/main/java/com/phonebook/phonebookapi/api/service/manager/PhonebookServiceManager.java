package com.phonebook.phonebookapi.api.service.manager;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;

public interface PhonebookServiceManager {

    AddPhonebookResponse enlist(AddPhonebookRequest addPhonebookRequest);
}
