package com.onlineStore.EStore.Service;

import com.onlineStore.EStore.DTO.AcartItemRequest;
import com.onlineStore.EStore.DTO.ApiResponseMessage;
import com.onlineStore.EStore.Entity.CartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartImpl {
    // add items to cart
    // case 1  if user is not available : we will add the cart
    // case2: cart available add item to card

    ResponseEntity<ApiResponseMessage> addItemInCart(AcartItemRequest req);


    // get all item of the particular cart
       List<CartItem> getAllCartOfParticularCart(int cartId);

   //  get All Items Of The Cart of particular user
   List<CartItem> getAllCartItemOfParticularUser(int userId);

   // delete Item in the cart
    ResponseEntity<ApiResponseMessage> deleteCartItemRequest(AcartItemRequest req);

}
