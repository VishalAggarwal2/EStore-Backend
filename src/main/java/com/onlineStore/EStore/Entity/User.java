package com.onlineStore.EStore.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name = "email",unique = true)
    private  String email;
    private String name;
    private String  password;
    private String about;
    private String image;

}
