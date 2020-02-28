package com.phonebook.phonebookapi.api.service.manager.data.repository;

import com.phonebook.phonebookapi.api.service.manager.data.models.Phonebook;
import org.springframework.data.repository.CrudRepository;

public interface PhonebookRepository extends CrudRepository<Phonebook, Integer>{
}