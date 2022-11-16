package com.example.securestuff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    Long id;

    @Column
    String username;

    @Column
    String password;

    @Column
    String roles;
}
