package com.phonebook.phonebookapi.api.utilities;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.responses.ValidateRequestBodyResponses;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface PhonebookUtilities {

    boolean ValidateQueryParams(String name);
    boolean ValidateHeaderParams(String clientId) throws IOException;
    ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookRequest addPhonebookRequest);
}
