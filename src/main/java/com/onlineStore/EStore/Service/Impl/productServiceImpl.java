package com.onlineStore.EStore.Service.Impl;

import com.onlineStore.EStore.DTO.categoryDTO;
import com.onlineStore.EStore.DTO.productDTO;
import com.onlineStore.EStore.Entity.Category;
import com.onlineStore.EStore.Entity.Product;
import com.onlineStore.EStore.Repository.productRepo;
import com.onlineStore.EStore.Service.productImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class productServiceImpl implements productImpl {
    @Autowired
    public productRepo pr;

    @Autowired
    public ModelMapper mapper;







    @Override
    public productDTO createProduct(productDTO product) {
        Product p = pr.save(dtotoEntity(product));
        return entityToDto(p);
    }

    @Override
    public List<productDTO> getAll() {
        List<Product> c = pr.findAll();
        List<productDTO> clist= c.stream().map(this::entityToDto)
                .collect(Collectors.toList());
        return  clist;
    }

    @Override
    public List<productDTO> getAllLive() {
        return List.of();
    }

    @Override
    public List<productDTO> productInString() {
        return List.of();
    }







    public productDTO entityToDto(Product p){
        return mapper.map(p, productDTO.class);
    }

    public Product dtotoEntity(productDTO p){
        return mapper.map(p,Product.class);
    }
}
