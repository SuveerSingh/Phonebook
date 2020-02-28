package com.phonebook.phonebookapi.api.service.manager.data.repository;

import com.phonebook.phonebookapi.api.service.manager.data.models.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Integer> {
}
