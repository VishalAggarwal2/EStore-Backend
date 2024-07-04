package com.onlineStore.EStore.Service;

import com.onlineStore.EStore.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
// create User
    ResponseEntity<UserDTO> createUser(UserDTO user);

    List<UserDTO> getAllUser();

    // delete user
    void deleteUser(int userId);
    // updateUser
    UserDTO updateUser(UserDTO user);

    // find userby id
    UserDTO findUserById(int Id);

    // find user by email
    UserDTO findUserByEmail(String Email);


}
