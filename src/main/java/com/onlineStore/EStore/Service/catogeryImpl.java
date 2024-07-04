package com.onlineStore.EStore.Service;

import com.onlineStore.EStore.DTO.categoryDTO;
import com.onlineStore.EStore.DTO.productDTO;

import java.util.List;

public interface catogeryImpl {
    categoryDTO createCategory(categoryDTO category);
    List<categoryDTO> getAll();
    categoryDTO getDetailById(int ID);
    productDTO createProductAndCategory(productDTO pr,int cid);
}
