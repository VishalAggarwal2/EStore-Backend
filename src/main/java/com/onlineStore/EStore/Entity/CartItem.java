package com.onlineStore.EStore.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartItemId;

    @OneToOne
    private Product productdetail;

    private int totalQuantity;

    private int totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;
}


