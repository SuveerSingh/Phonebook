package com.phonebook.phonebookapi.api.controllers;

import com.phonebook.phonebookapi.api.models.request.*;
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
@CrossOrigin(origins = "http://locahost:4200", maxAge = 3600)
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
        try {
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
        } catch (Exception ex) {
            return ResponseEntity.status(BAD_REQUEST)
                    .body(new AddPhonebookResponse(GENERIC_EXCEPTION.getDescription(),
                            GENERIC_EXCEPTION.getErrorCode()));
        }

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @ApiOperation(value = "List all entries in a phonebook")
    @PostMapping(value = "/list-phonebooks")
    public ResponseEntity<ListPhonebookResponse> listPhonebooks(
            @RequestHeader("client-id") String clientId,
            @RequestBody ListPhonebookRequest listPhonebookRequest
    ) throws IOException {
        try {
            if (!phonebookUtilities.ValidateHeaderParams(clientId)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body(new ListPhonebookResponse(INVALID_CREDENTIALS.getErrorCode(),
                                INVALID_CREDENTIALS.getDescription()));
            }

            ValidateRequestBodyResponses validateRequestBodyResponses = phonebookUtilities.ValidateRequestBody(listPhonebookRequest);
            if (validateRequestBodyResponses == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ListPhonebookResponse(INVALID_REQUEST_BODY.getErrorCode(),
                                INVALID_REQUEST_BODY.getDescription()));
            }

            if (!validateRequestBodyResponses.status) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ListPhonebookResponse(validateRequestBodyResponses.getErrorCode(),
                                validateRequestBodyResponses.getErrorMessage()));
            }

            ListPhonebookResponse listPhonebookResponse = phonebookServiceManager.listPhonebooks(listPhonebookRequest);

            if (listPhonebookResponse != null) {
                return ResponseEntity.status(CREATED).body(listPhonebookResponse);
            }

            return ResponseEntity.status(BAD_REQUEST)
                    .body(new ListPhonebookResponse(UNABLE_TO_CREATE_PHONEBOOK.getDescription(),
                            UNABLE_TO_CREATE_PHONEBOOK.getErrorCode()));

        } catch (Exception ex) {
            return ResponseEntity.status(BAD_REQUEST)
                    .body(new ListPhonebookResponse(GENERIC_EXCEPTION.getDescription(),
                            GENERIC_EXCEPTION.getErrorCode()));
        }
    }


    @ApiOperation(value = "Add a new phonebook entry")
    @PostMapping(value = "/enlist-entry")
    public ResponseEntity<AddPhonebookEntryResponse> addPhonebookEntry(
            @RequestHeader("client-id") String clientId,
            @RequestBody AddPhonebookEntryRequest addPhonebookEntryRequest
    ) throws IOException {

        try {
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
        } catch (Exception ex) {
            return ResponseEntity.status(BAD_REQUEST)
                    .body(new AddPhonebookEntryResponse(GENERIC_EXCEPTION.getDescription(),
                            GENERIC_EXCEPTION.getErrorCode()));
        }
    }

    @ApiOperation(value = "List all entries in a phonebook")
    @PostMapping(value = "/list-entries")
    public ResponseEntity<ListPhoneBookEntriesResponse> listEntries(
            @RequestHeader("client-id") String clientId,
            @RequestBody ListPhonebookEntriesRequest listPhonebookEntriesRequest
    ) throws IOException {

        try {
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

            ListPhoneBookEntriesResponse listPhoneBookEntriesResponse = phonebookServiceManager.listEntries(listPhonebookEntriesRequest);

            if (listPhoneBookEntriesResponse != null) {
                return ResponseEntity.status(CREATED).body(listPhoneBookEntriesResponse);
            }

            return ResponseEntity.status(BAD_REQUEST)
                    .body(new ListPhoneBookEntriesResponse(UNABLE_TO_CREATE_PHONEBOOK.getDescription(),
                            UNABLE_TO_CREATE_PHONEBOOK.getErrorCode()));
        } catch (Exception ex) {
            return ResponseEntity.status(BAD_REQUEST)
                    .body(new ListPhoneBookEntriesResponse(GENERIC_EXCEPTION.getDescription(),
                            GENERIC_EXCEPTION.getErrorCode()));
        }
    }

    @ApiOperation(value = "Update a phonebook entry")
    @PostMapping(value = "/update-entry")
    public ResponseEntity<UpdatePhonebookEntryResponse> update(
            @RequestHeader("client-id") String clientId,
            @RequestBody UpdatePhonebookEntryRequest updatePhonebookEntryRequest
    ) throws IOException {

        try {
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
        } catch (Exception ex) {
            return ResponseEntity.status(BAD_REQUEST)
                    .body(new UpdatePhonebookEntryResponse(GENERIC_EXCEPTION.getDescription(),
                            GENERIC_EXCEPTION.getErrorCode()));
        }
    }
}

