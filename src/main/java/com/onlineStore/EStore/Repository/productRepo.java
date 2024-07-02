package com.onlineStore.EStore.Repository;

import com.onlineStore.EStore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepo extends JpaRepository<Product,Integer> {
    List<Product> findByProductNameContaining(String substring);
    List<Product> findByIsLiveTrue();

}
