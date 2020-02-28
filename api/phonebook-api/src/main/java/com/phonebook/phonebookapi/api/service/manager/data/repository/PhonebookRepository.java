package com.phonebook.phonebookapi.api.service.manager.data.repository;

import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBook;
import org.springframework.data.repository.CrudRepository;

public interface PhonebookRepository extends CrudRepository<PhoneBook, Integer>{

    PhoneBook findByDescription(String description);
}