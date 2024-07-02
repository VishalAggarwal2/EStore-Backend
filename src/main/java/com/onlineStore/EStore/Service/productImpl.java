package com.onlineStore.EStore.Service;

import com.onlineStore.EStore.DTO.productDTO;

import java.util.List;

public interface productImpl {
    // create product
    productDTO createProduct(productDTO product);

    // get All Product product
    List<productDTO> getAll();

    //get All Product that is live
    List<productDTO> getAllLive();


    // list of product contaioning the string
    List<productDTO> productInString();
}
