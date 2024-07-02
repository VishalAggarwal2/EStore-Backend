package com.onlineStore.EStore.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(name = "email",unique = true)
    private  String email;
     private String name;
    @Column(length = 1000)
    private String  password;
    @Column(length = 1000)
    private String about;
    private String image;
}
