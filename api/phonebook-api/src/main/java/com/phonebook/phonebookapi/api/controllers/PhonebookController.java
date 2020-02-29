package com.phonebook.phonebookapi.api.controllers;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.request.ListPhonebookEntriesRequest;
import com.phonebook.phonebookapi.api.models.request.UpdatePhonebookEntryRequest;
import com.phonebook.phonebookapi.api.models.responses.*;
import com.phonebook.phonebookapi.api.service.manager.PhonebookServiceManager;
import com.phonebook.phonebookapi.api.utilities.PhonebookUtilities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.phonebook.phonebookapi.api.models.helpers.ErrorResponses.*;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@Api(value = "Phonebook API", tags = {"Phonebook API"})
@RestController
@RequestMapping("/phonebook")
public class PhonebookController {

    private final PhonebookServiceManager phonebookServiceManager;
    private final PhonebookUtilities phonebookUtilities;

    public PhonebookController(PhonebookServiceManager phonebookServiceManager,
                               PhonebookUtilities phonebookUtilities) {
        this.phonebookServiceManager = phonebookServiceManager;
        this.phonebookUtilities = phonebookUtilities;
    }


    @ApiOperation(value = "Add a new phonebook")
    @PostMapping(value = "/enlist")
    public ResponseEntity<AddPhonebookResponse> addPhonebook(
            @RequestHeader("client-id") String clientId,
            @RequestBody AddPhonebookRequest addPhonebookRequest
    ) throws IOException {

        if (!phonebookUtilities.ValidateHeaderParams(clientId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new AddPhonebookResponse(INVALID_CREDENTIALS.getErrorCode(),
                            INVALID_CREDENTIALS.getDescription()));
        }

        ValidateRequestBodyResponses validateRequestBodyResponses = phonebookUtilities.ValidateRequestBody(addPhonebookRequest);
        if (validateRequestBodyResponses == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AddPhonebookResponse(INVALID_REQUEST_BODY.getErrorCode(),
                            INVALID_REQUEST_BODY.getDescription()));
        }

        if (!validateRequestBodyResponses.status) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AddPhonebookResponse(validateRequestBodyResponses.getErrorCode(),
                            validateRequestBodyResponses.getErrorMessage()));
        }

        AddPhonebookResponse addPhonebookResponse = phonebookServiceManager.enlist(addPhonebookRequest);

        if (addPhonebookResponse != null) {
            if (addPhonebookResponse.isStatus()) {
                return ResponseEntity.status(CREATED).body(addPhonebookResponse);
            }
            return ResponseEntity.status(BAD_REQUEST).body(addPhonebookResponse);
        }

        return ResponseEntity.status(BAD_REQUEST)
                .body(new AddPhonebookResponse(UNABLE_TO_CREATE_PHONEBOOK.getDescription(),
                        UNABLE_TO_CREATE_PHONEBOOK.getErrorCode()));
    }

    @ApiOperation(value = "Add a new phonebook entry")
    @PostMapping(value = "/enlist-entry")
    public ResponseEntity<AddPhonebookEntryResponse> addPhonebookEntry(
            @RequestHeader("client-id") String clientId,
            @RequestBody AddPhonebookEntryRequest addPhonebookEntryRequest
    ) throws IOException {

        if (!phonebookUtilities.ValidateHeaderParams(clientId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new AddPhonebookEntryResponse(INVALID_CREDENTIALS.getErrorCode(),
                            INVALID_CREDENTIALS.getDescription()));
        }

        ValidateRequestBodyResponses validateRequestBodyResponses = phonebookUtilities.ValidateRequestBody(addPhonebookEntryRequest);
        if (validateRequestBodyResponses == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AddPhonebookEntryResponse(INVALID_REQUEST_BODY.getErrorCode(),
                            INVALID_REQUEST_BODY.getDescription()));
        }

        if (!validateRequestBodyResponses.status) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AddPhonebookEntryResponse(validateRequestBodyResponses.getErrorCode(),
                            validateRequestBodyResponses.getErrorMessage()));
        }

        AddPhonebookEntryResponse addPhonebookEntryResponse = phonebookServiceManager.enlistEntry(addPhonebookEntryRequest);

        if (addPhonebookEntryResponse != null) {
            if (addPhonebookEntryResponse.isStatus()) {
                return ResponseEntity.status(CREATED).body(addPhonebookEntryResponse);
            }
            return ResponseEntity.status(BAD_REQUEST).body(addPhonebookEntryResponse);
        }

        return ResponseEntity.status(BAD_REQUEST)
                .body(new AddPhonebookEntryResponse(UNABLE_TO_CREATE_PHONEBOOK.getDescription(),
                        UNABLE_TO_CREATE_PHONEBOOK.getErrorCode()));
    }

    @ApiOperation(value = "List all entries in a phonebook")
    @PostMapping(value = "/list")
    public ResponseEntity<ListPhoneBookEntriesResponse> list(
            @RequestHeader("client-id") String clientId,
            @RequestBody ListPhonebookEntriesRequest listPhonebookEntriesRequest
    ) throws IOException {

        if (!phonebookUtilities.ValidateHeaderParams(clientId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ListPhoneBookEntriesResponse(INVALID_CREDENTIALS.getErrorCode(),
                            INVALID_CREDENTIALS.getDescription()));
        }

        ValidateRequestBodyResponses validateRequestBodyResponses = phonebookUtilities.ValidateRequestBody(listPhonebookEntriesRequest);
        if (validateRequestBodyResponses == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ListPhoneBookEntriesResponse(INVALID_REQUEST_BODY.getErrorCode(),
                            INVALID_REQUEST_BODY.getDescription()));
        }

        if (!validateRequestBodyResponses.status) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ListPhoneBookEntriesResponse(validateRequestBodyResponses.getErrorCode(),
                            validateRequestBodyResponses.getErrorMessage()));
        }

        ListPhoneBookEntriesResponse listPhoneBookEntriesResponse = phonebookServiceManager.list(listPhonebookEntriesRequest);

        if (listPhoneBookEntriesResponse != null) {
            return ResponseEntity.status(CREATED).body(listPhoneBookEntriesResponse);
        }

        return ResponseEntity.status(BAD_REQUEST)
                .body(new ListPhoneBookEntriesResponse(UNABLE_TO_CREATE_PHONEBOOK.getDescription(),
                        UNABLE_TO_CREATE_PHONEBOOK.getErrorCode()));
    }

    @ApiOperation(value = "Update a phonebook entry")
    @PostMapping(value = "/update-entry")
    public ResponseEntity<UpdatePhonebookEntryResponse> update(
            @RequestHeader("client-id") String clientId,
            @RequestBody UpdatePhonebookEntryRequest updatePhonebookEntryRequest
    ) throws IOException {

        if (!phonebookUtilities.ValidateHeaderParams(clientId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new UpdatePhonebookEntryResponse(INVALID_CREDENTIALS.getErrorCode(),
                            INVALID_CREDENTIALS.getDescription()));
        }

        ValidateRequestBodyResponses validateRequestBodyResponses = phonebookUtilities.ValidateRequestBody(updatePhonebookEntryRequest);
        if (validateRequestBodyResponses == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new UpdatePhonebookEntryResponse(INVALID_REQUEST_BODY.getErrorCode(),
                            INVALID_REQUEST_BODY.getDescription()));
        }

        if (!validateRequestBodyResponses.status) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new UpdatePhonebookEntryResponse(validateRequestBodyResponses.getErrorCode(),
                            validateRequestBodyResponses.getErrorMessage()));
        }

        UpdatePhonebookEntryResponse updatePhonebookEntryResponse = phonebookServiceManager.updateEntry(updatePhonebookEntryRequest);

        if (updatePhonebookEntryResponse != null) {
            return ResponseEntity.status(ACCEPTED).body(updatePhonebookEntryResponse);
        }

        return ResponseEntity.status(BAD_REQUEST)
                .body(new UpdatePhonebookEntryResponse(UNABLE_TO_CREATE_PHONEBOOK.getDescription(),
                        UNABLE_TO_CREATE_PHONEBOOK.getErrorCode()));
    }
}

