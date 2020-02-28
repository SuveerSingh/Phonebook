package com.phonebook.phonebookapi.api.utilities.impl;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.responses.ValidateRequestBodyResponses;
import com.phonebook.phonebookapi.api.utilities.PhonebookUtilities;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PhonebookUtilitiesImpl implements PhonebookUtilities {
    @Override
    public boolean ValidateQueryParams(String name) {
        return false;
    }

    @Override
    public boolean ValidateHeaderParams(String clientId) throws IOException {
        return false;
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookRequest addPhonebookRequest) {
        return null;
    }
}
