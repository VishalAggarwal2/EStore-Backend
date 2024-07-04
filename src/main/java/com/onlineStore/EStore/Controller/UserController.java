package com.onlineStore.EStore.Controller;

import com.onlineStore.EStore.DTO.UserDTO;
import com.onlineStore.EStore.Service.Impl.UserServiceImpl;
import com.onlineStore.EStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserServiceImpl us;

    @GetMapping("/signup")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        System.out.println(user);
        return us.createUser(user);
    }

    @GetMapping("/id")
    public UserDTO findUserById(@RequestBody int id){
        System.out.println("id is");
        System.out.println(id);
        return  us.findUserById(id);
    }

    @GetMapping("/email")
    public UserDTO findByEmail(@RequestBody String email){
        return us.findUserByEmail(email);
    }

    @GetMapping("/alluser")
    public List<UserDTO> getAllUser(){

        return us.getAllUser();
    }


}
