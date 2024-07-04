package com.onlineStore.EStore.Controller;

import com.onlineStore.EStore.DTO.AcartItemRequest;
import com.onlineStore.EStore.DTO.ApiResponseMessage;
import com.onlineStore.EStore.Entity.CartItem;
import com.onlineStore.EStore.Service.Impl.cartItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {
    @Autowired
    private cartItemServiceImpl cs;
    @GetMapping("/test")
    public String test(){
        return "cart tested";
    }
    @GetMapping("/additem")
    ResponseEntity<ApiResponseMessage> addItemInCart(@RequestBody AcartItemRequest request){
    return  cs.addItemInCart(request);
    }

    @GetMapping("/all/{userId}")
    public List<CartItem> getAllCartItemOfParticularUser(@PathVariable int userId){
        System.out.println("called ");
        return  cs.getAllCartItemOfParticularUser(userId);
    }
}
