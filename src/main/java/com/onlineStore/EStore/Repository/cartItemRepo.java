package com.onlineStore.EStore.Repository;

import com.onlineStore.EStore.Entity.Cart;
import com.onlineStore.EStore.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cartItemRepo extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByCart(Cart cart);
}
