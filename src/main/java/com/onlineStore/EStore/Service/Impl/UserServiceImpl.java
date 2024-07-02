package com.onlineStore.EStore.Service.Impl;

import com.onlineStore.EStore.DTO.UserDTO;
import com.onlineStore.EStore.Entity.User;
import com.onlineStore.EStore.Repository.userRepository;
import com.onlineStore.EStore.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private userRepository userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO user) {
        User u= userRepo.save(userDtoToUserEntity(user));
        UserDTO savedUserDTO = mapper.map(u, UserDTO.class);
        return ResponseEntity.ok(savedUserDTO); // Simplified ResponseEntity creation
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(this::userEntityToUserDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteUser(String userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User updatedUser = userRepo.save(userDtoToUserEntity(user));
        return userEntityToUserDto(updatedUser);
    }

    @Override
    public UserDTO findUserById(String id) {
        return userRepo.findById(id)
                .map(this::userEntityToUserDto)
                .orElse(null);
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return user != null ? userEntityToUserDto(user) : null;
    }



    private User userDtoToUserEntity(UserDTO user) {
        return mapper.map(user, User.class);
    }

    private UserDTO userEntityToUserDto(User user) {
        return mapper.map(user, UserDTO.class);
    }

}
