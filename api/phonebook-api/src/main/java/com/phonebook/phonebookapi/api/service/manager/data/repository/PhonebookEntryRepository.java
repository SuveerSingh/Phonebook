package com.phonebook.phonebookapi.api.service.manager.data.repository;

import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBookEntry;
import org.springframework.data.repository.CrudRepository;

public interface PhonebookEntryRepository extends CrudRepository<PhoneBookEntry, Integer> {
}
