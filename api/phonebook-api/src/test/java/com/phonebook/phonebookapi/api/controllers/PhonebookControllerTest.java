package com.phonebook.phonebookapi.api.controllers;

import com.phonebook.phonebookapi.api.models.helpers.ErrorResponses;
import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.models.responses.ValidateRequestBodyResponses;
import com.phonebook.phonebookapi.api.service.manager.PhonebookServiceManager;
import com.phonebook.phonebookapi.api.utilities.PhonebookUtilities;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class PhonebookControllerTest {

    private static final String CLIENT_ID = "e5c08502-e4b9-4f3e-a2c3-eab9680bbbe7";
    private static final String INVALID_CLIENT_ID_INCORRECT_ID = "INVALID";
    private static final String EMPTY_STRING = "";

    @InjectMocks
    private PhonebookController phonebookController;
    @Mock
    private PhonebookServiceManager phonebookServiceManager;
    @Mock
    private PhonebookUtilities phonebookUtilities;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(phonebookController)
                .build();
    }

    @Test
    public void PhonebookAPI_Enlist_InvalidChannelCredentials() throws Exception {

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/enlist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", INVALID_CLIENT_ID_INCORRECT_ID)
                        .content("{\n" +
                                "\t\"description\":\"Phonebook 1\"\n" +
                                "}")
        ).andDo(
                print()
        ).andExpect(
                status().isForbidden()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_CREDENTIALS.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_CREDENTIALS.getErrorCode())
        ).andReturn();
    }

    @Test
    public void PhonebookAPI_Enlist_InvalidRequestBody() throws Exception {

        when(
                phonebookUtilities.ValidateHeaderParams(eq(CLIENT_ID))
        ).thenReturn(true);

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/enlist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", CLIENT_ID)
                        .content("{\n" +
                                "}")

        ).andDo(
                print()
        ).andExpect(
                status().isBadRequest()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_REQUEST_BODY.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_REQUEST_BODY.getErrorCode())
        ).andReturn();
    }

    @Test
    public void PhonebookAPI_EnlistEntry_InvalidChannelCredentials() throws Exception {

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/enlist-entry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", INVALID_CLIENT_ID_INCORRECT_ID)
                        .content("{\n" +
                                "\t\"phonebookDescription\":\"Phonebook 1\",\n" +
                                "\t\"description\":\"test\",\n" +
                                "\t\"phoneNumber\":\"123456\"\n" +
                                "}")
        ).andDo(
                print()
        ).andExpect(
                status().isForbidden()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_CREDENTIALS.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_CREDENTIALS.getErrorCode())
        ).andReturn();
    }

    @Test
    public void PhonebookAPI_EnlistEntry_InvalidRequestBody() throws Exception {

        when(
                phonebookUtilities.ValidateHeaderParams(eq(CLIENT_ID))
        ).thenReturn(true);

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/enlist-entry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", CLIENT_ID)
                        .content("{\n" +
                                "\t\"description\":\"test\",\n" +
                                "\t\"phoneNumber\":\"123456\"\n" +
                                "}")

        ).andDo(
                print()
        ).andExpect(
                status().isBadRequest()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_REQUEST_BODY.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_REQUEST_BODY.getErrorCode())
        ).andReturn();
    }

    @Test
    public void PhonebookAPI_List_InvalidChannelCredentials() throws Exception {

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/list-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", INVALID_CLIENT_ID_INCORRECT_ID)
                        .content("{\n" +
                                "\t\"userId\":1\n" +
                                "}")
        ).andDo(
                print()
        ).andExpect(
                status().isForbidden()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_CREDENTIALS.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_CREDENTIALS.getErrorCode())
        ).andReturn();
    }

    @Test
    public void PhonebookAPI_List_InvalidRequestBody() throws Exception {

        when(
                phonebookUtilities.ValidateHeaderParams(eq(CLIENT_ID))
        ).thenReturn(true);

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/list-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", CLIENT_ID)
                        .content("{\n" +
                                "\t\"userId\":0\n" +
                                "}")

        ).andDo(
                print()
        ).andExpect(
                status().isBadRequest()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_REQUEST_BODY.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_REQUEST_BODY.getErrorCode())
        ).andReturn();
    }

    @Test
    public void PhonebookAPI_Update_InvalidChannelCredentials() throws Exception {

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/update-entry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", INVALID_CLIENT_ID_INCORRECT_ID)
                        .content("{\n" +
                                "\t\"phonebookEntryId\":1,\n" +
                                "\t\"description\":\"test\",\n" +
                                "\t\"phoneNumber\":\"123456\"\n" +
                                "}")
        ).andDo(
                print()
        ).andExpect(
                status().isForbidden()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_CREDENTIALS.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_CREDENTIALS.getErrorCode())
        ).andReturn();
    }

    @Test
    public void PhonebookAPI_Update_InvalidRequestBody() throws Exception {

        when(
                phonebookUtilities.ValidateHeaderParams(eq(CLIENT_ID))
        ).thenReturn(true);

        final MvcResult mvcResult = this.mockMvc.perform(
                post("/phonebook/update-entry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("client-id", CLIENT_ID)
                        .content("{\n" +
                                "\t\"phonebookEntryId\":1,\n" +
                                "\t\"description\":\"test\",\n" +
                                "\t\"phoneNumber\":\"123456\"\n" +
                                "}")

        ).andDo(
                print()
        ).andExpect(
                status().isBadRequest()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorMessage").value(ErrorResponses.INVALID_REQUEST_BODY.getDescription())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorResponses.INVALID_REQUEST_BODY.getErrorCode())
        ).andReturn();
    }
}
