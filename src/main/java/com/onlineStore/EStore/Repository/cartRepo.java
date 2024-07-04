package com.onlineStore.EStore.Repository;

import com.onlineStore.EStore.Entity.Cart;
import com.onlineStore.EStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface cartRepo extends JpaRepository<Cart,Integer> {
    Optional<Cart> findByUser(User user);
}
