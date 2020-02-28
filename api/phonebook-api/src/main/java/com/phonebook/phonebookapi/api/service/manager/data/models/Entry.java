package com.phonebook.phonebookapi.api.service.manager.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String phoneNumber;
    private String description;

    @ManyToOne
    @JoinColumn
    private Phonebook phonebook;

    public Entry(String phoneNumber,
                 String description,
                 Phonebook phonebook) {
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.phonebook = phonebook;
    }
}
