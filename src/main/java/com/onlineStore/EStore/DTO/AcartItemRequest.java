package com.onlineStore.EStore.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcartItemRequest {
    private int productId;
    private int userId;
    private int quantity;
}
