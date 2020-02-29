package com.phonebook.phonebookapi.api.utilities.impl;

import com.phonebook.phonebookapi.api.models.helpers.ErrorResponses;
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

    public static boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean ValidateHeaderParams(String clientId) throws IOException {
        if (clientId == null) {
            return false;
        }

        if (clientId.length() != 0) {
            return false;
        }

        if (!clientId.equals("e5c08502-e4b9-4f3e-a2c3-eab9680bbbe7")) {
            return false;
        }

        return true;
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookRequest addPhonebookRequest) {

        if (addPhonebookRequest == null) {
            return new ValidateRequestBodyResponses(ErrorResponses.INVALID_REQUEST_BODY.getDescription(),
                    ErrorResponses.INVALID_REQUEST_BODY.getErrorCode());
        }

        if (isNullOrEmpty(addPhonebookRequest.getUserId())) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        if (isNullOrEmpty(addPhonebookRequest.getDescription())) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        return new ValidateRequestBodyResponses(true);
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(AddPhonebookEntryRequest addPhonebookEntryRequest) {

        if (addPhonebookEntryRequest == null) {
            return new ValidateRequestBodyResponses(ErrorResponses.INVALID_REQUEST_BODY.getDescription(),
                    ErrorResponses.INVALID_REQUEST_BODY.getErrorCode());
        }

        if (isNullOrEmpty(addPhonebookEntryRequest.getPhonebookDescription())) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        if (isNullOrEmpty(addPhonebookEntryRequest.getPhoneNumber())) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        if (isNullOrEmpty(addPhonebookEntryRequest.getDescription())) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        return new ValidateRequestBodyResponses(true);
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(ListPhonebookEntriesRequest listPhonebookEntriesRequest) {

        if (listPhonebookEntriesRequest == null) {
            return new ValidateRequestBodyResponses(ErrorResponses.INVALID_REQUEST_BODY.getDescription(),
                    ErrorResponses.INVALID_REQUEST_BODY.getErrorCode());
        }

        if (listPhonebookEntriesRequest.getUserId() == 0) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        return new ValidateRequestBodyResponses(true);
    }

    @Override
    public ValidateRequestBodyResponses ValidateRequestBody(UpdatePhonebookEntryRequest updatePhonebookEntryRequest) {

        if (updatePhonebookEntryRequest == null) {
            return new ValidateRequestBodyResponses(ErrorResponses.INVALID_REQUEST_BODY.getDescription(),
                    ErrorResponses.INVALID_REQUEST_BODY.getErrorCode());
        }

        if (isNullOrEmpty(updatePhonebookEntryRequest.getDescription())) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        if (isNullOrEmpty(updatePhonebookEntryRequest.getPhoneNumber())) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        if (updatePhonebookEntryRequest.getPhonebookEntryId() == 0) {
            return new ValidateRequestBodyResponses(ErrorResponses.NULL_VALUE_IN_REQUEST.getDescription(),
                    ErrorResponses.NULL_VALUE_IN_REQUEST.getErrorCode());
        }

        return new ValidateRequestBodyResponses(true);
    }
}
