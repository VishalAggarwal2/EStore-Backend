package com.onlineStore.EStore.Service.Impl;

import com.onlineStore.EStore.DTO.AcartItemRequest;
import com.onlineStore.EStore.DTO.ApiResponseMessage;
import com.onlineStore.EStore.Entity.Cart;
import com.onlineStore.EStore.Entity.CartItem;
import com.onlineStore.EStore.Entity.Product;
import com.onlineStore.EStore.Entity.User;
import com.onlineStore.EStore.Excptions.ResourceNotFoundException;
import com.onlineStore.EStore.Repository.cartItemRepo;
import com.onlineStore.EStore.Repository.cartRepo;
import com.onlineStore.EStore.Repository.productRepo;
import com.onlineStore.EStore.Repository.userRepository;
import com.onlineStore.EStore.Service.CartImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cartItemServiceImpl implements CartImpl {
    @Autowired
    private productRepo pr;

    @Autowired
    private cartItemRepo cir;

    @Autowired
    private cartRepo cr;

    @Autowired
    private userRepository ur;


    @Override
    public ResponseEntity<ApiResponseMessage> addItemInCart(AcartItemRequest req) {
        Optional<Product> product = pr.findById(req.getProductId());
        Product p = product.orElseThrow(() -> new ResourceNotFoundException("Category Resource Not Found"));
  int totalCartPrice = (req.getQuantity())*(p.getPrice());
        Optional<User> user = ur.findById(req.getUserId());
        User u = user.orElseThrow(() -> new ResourceNotFoundException("Category Resource Not Found"));

    Optional<Cart> c = cr.findByUser(u);

    Cart csrt = c.orElseGet(()->{
        System.out.println("New Crt Created");
        Cart newCart = new Cart();
        newCart.setUser(u);
        return cr.save(newCart);
    });


        System.out.println("Old Cart Created");
        CartItem ci  = CartItem.builder().cart(csrt).productdetail(p).totalQuantity(req.getQuantity()).totalAmount(totalCartPrice).build();
        CartItem saved = cir.save(ci);
        ApiResponseMessage message = ApiResponseMessage.builder().status(HttpStatus.OK).message("Product Added To Cart Succ").Success(true).build();
        return new ResponseEntity<ApiResponseMessage>(message,HttpStatus.OK);

    }





    @Override
    public List<CartItem> getAllCartOfParticularCart(int cartId) {
      Optional<Cart> tempcart = cr.findById(cartId);
      Cart ca = tempcart.orElseThrow(()->new ResourceNotFoundException("Resource No Foud"));
List<CartItem> allItems = cir.findByCart(ca);
return allItems;
    }

    @Override
    public List<CartItem> getAllCartItemOfParticularUser(int userId) {
        Optional<User> user = ur.findById(userId);
        User u = user.orElseThrow(() -> new ResourceNotFoundException("Category Resource Not Found"));
        Optional<Cart> c = cr.findByUser(u);
        Cart cf = c.orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
        List<CartItem> allItems = cir.findByCart(cf);
        return allItems;

    }

    @Override
    public ResponseEntity<ApiResponseMessage> deleteCartItemRequest(AcartItemRequest req) {
        return null;
    }
}
