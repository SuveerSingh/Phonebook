package com.phonebook.phonebookapi.api.service.manager.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name="phone_book")
@Getter
@Setter
@NoArgsConstructor
public class PhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String description;

    @OneToMany(mappedBy = "phonebook", cascade = CascadeType.ALL)
    private Set<PhoneBookEntry> phonebookEntry;

    public PhoneBook(int id,
                     String description) {
        this.id = id;
        this.description = description;
    }
}
