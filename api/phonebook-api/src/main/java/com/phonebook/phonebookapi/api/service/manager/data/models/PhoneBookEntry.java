package com.phonebook.phonebookapi.api.service.manager.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="phone_book_entry")
@Getter
@Setter
@NoArgsConstructor
public class PhoneBookEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn
    private PhoneBook phonebook;

    private String phoneNumber;
    private String description;

    public PhoneBookEntry(String phoneNumber,
                          String description) {
        this.phoneNumber = phoneNumber;
        this.description = description;

    }
}
