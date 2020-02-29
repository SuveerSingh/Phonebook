package com.phonebook.phonebookapi.api.utilities;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.request.UpdatePhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.responses.ValidateRequestBodyResponses;

import java.io.IOException;


public interface PhonebookUtilities {

    boolean ValidateHeaderParams(String clientId) throws IOException;
    ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookRequest addPhonebookRequest);
    ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookEntryRequest addPhonebookRequest);
    ValidateRequestBodyResponses ValidateRequestBody(ListPhonebookEntriesRequest listPhonebookEntriesRequest);
    ValidateRequestBodyResponses ValidateRequestBody(UpdatePhonebookEntryRequest updatePhonebookEntryRequest);
}
