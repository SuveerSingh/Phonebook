package com.phonebook.phonebookapi.api.utilities.impl;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.request.UpdatePhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.responses.ValidateRequestBodyResponses;
import com.phonebook.phonebookapi.api.utilities.PhonebookUtilities;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PhonebookUtilitiesImpl implements PhonebookUtilities {

    @Override
    public boolean ValidateHeaderParams(String clientId) throws IOException {
        return clientId != null && clientId.length() != 0;
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookRequest addPhonebookRequest) {
        return new ValidateRequestBodyResponses(true);
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookEntryRequest addPhonebookEntryRequest) {
        return new ValidateRequestBodyResponses(true);
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(ListPhonebookEntriesRequest listPhonebookEntriesRequest) {
        return new ValidateRequestBodyResponses(true);
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(UpdatePhonebookEntryRequest updatePhonebookEntryRequest) {
        return new ValidateRequestBodyResponses(true);
    }
}
