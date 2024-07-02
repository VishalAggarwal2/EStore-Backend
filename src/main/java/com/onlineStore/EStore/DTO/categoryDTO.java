package com.onlineStore.EStore.DTO;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class categoryDTO {
    private  Integer id;
    private String categoreyName;
    private String categoryDsc;
    private String catogeryImage;

}
