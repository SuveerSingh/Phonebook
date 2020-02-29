package com.phonebook.phonebookapi.api.service.manager.data.repository;

import com.phonebook.phonebookapi.api.service.manager.data.models.PhoneBookEntry;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PhonebookEntryRepository extends CrudRepository<PhoneBookEntry, Integer> {

    List<PhoneBookEntry> findPhonebookEntryByPhonebookId(int phonebookId);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE phone_book_entry SET description = :description, phone_number = :phone_number WHERE id = :id")
    void updateDescriptionAndPhoneNumberById(@Param("id") int id,
                                  @Param("description") String description,
                                  @Param("phone_number") String phoneNumber);
}
