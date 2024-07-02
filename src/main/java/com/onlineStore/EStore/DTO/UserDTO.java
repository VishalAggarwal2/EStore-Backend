package com.onlineStore.EStore.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Integer userId;
    private  String email;
    private String name;
    private String  password;
    private String about;
    private String image;
}


