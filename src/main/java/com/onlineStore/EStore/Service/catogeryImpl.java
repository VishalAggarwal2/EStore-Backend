package com.onlineStore.EStore.Service;

import com.onlineStore.EStore.DTO.categoryDTO;

import java.util.List;

public interface catogeryImpl {

    // create Category
    categoryDTO createCategory(categoryDTO category);

    // getAll category
    List<categoryDTO> getAll();

    // get detail of the category on the basics of their id
    categoryDTO getDetailById(int ID);


}
