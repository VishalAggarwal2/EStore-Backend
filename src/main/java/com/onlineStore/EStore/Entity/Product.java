package com.onlineStore.EStore.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int productId;
    private  String productName;
    private  String productDsc;
    private int quantity;
    private int price;
    private boolean isLive;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
