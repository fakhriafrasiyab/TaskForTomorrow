package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "accountant_name")
    @NotNull(message = "Please provide a name")
    @Size(min = 2, max = 12, message = "Name should have at least 2 characters")
    private String accountant_name;

}
