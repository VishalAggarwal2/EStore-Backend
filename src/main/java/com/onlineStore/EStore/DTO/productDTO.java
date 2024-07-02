package com.onlineStore.EStore.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class productDTO {
    private int productId;
    private  String productName;
    private  String productDsc;
    private int quantity;
    private int price;
    private boolean isLive;
}
