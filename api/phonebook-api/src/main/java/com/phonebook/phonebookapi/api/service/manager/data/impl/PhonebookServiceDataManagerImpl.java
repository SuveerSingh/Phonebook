package com.phonebook.phonebookapi.api.service.manager.data.impl;

import com.phonebook.phonebookapi.api.models.request.AddPhonebookRequest;
import com.phonebook.phonebookapi.api.models.responses.AddPhonebookResponse;
import com.phonebook.phonebookapi.api.service.manager.data.PhonebookServiceDataManager;
import com.phonebook.phonebookapi.api.service.manager.data.models.Phonebook;
import com.phonebook.phonebookapi.api.service.manager.data.repository.PhonebookRepository;
import org.springframework.stereotype.Service;

@Service
public class PhonebookServiceDataManagerImpl implements PhonebookServiceDataManager {

    private final PhonebookRepository phonebookRepository;

    public PhonebookServiceDataManagerImpl(PhonebookRepository phonebookRepository) {
        this.phonebookRepository = phonebookRepository;
    }

    @Override
    public AddPhonebookResponse enlist(AddPhonebookRequest addPhonebookRequest) {

        Phonebook phonebook = new Phonebook();
        phonebook.setDescription(addPhonebookRequest.getDescription());

        phonebookRepository.save(phonebook);

        return new AddPhonebookResponse(true);
    }
}
