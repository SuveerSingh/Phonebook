package com.phonebook.phonebookapi.api.controllers;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.models.responses.ValidateRequestBodyResponses;
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
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

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
}

