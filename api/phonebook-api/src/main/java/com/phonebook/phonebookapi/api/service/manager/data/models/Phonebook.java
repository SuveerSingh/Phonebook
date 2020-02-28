package com.phonebook.phonebookapi.api.service.manager.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Phonebook {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String description;

    @OneToMany(mappedBy = "phonebook", cascade = CascadeType.ALL)
    private Set<Phonebook> phonebook;

    public Phonebook(int id,
                      String description) {
        this.id = id;
        this.description = description;
    }
}
