package com.onlineStore.EStore.Service.Impl;

import com.onlineStore.EStore.DTO.categoryDTO;
import com.onlineStore.EStore.Entity.Category;
import com.onlineStore.EStore.Excptions.ResourceNotFoundException;
import com.onlineStore.EStore.Repository.categoryRepo;
import com.onlineStore.EStore.Service.catogeryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class catyegoryServicImpl implements catogeryImpl {
    @Autowired
    public categoryRepo cr;

    @Autowired
    public ModelMapper mapper;


    @Override
    public categoryDTO createCategory(categoryDTO category) {
        Category c= cr.save(dtoToEntity(category));
        return entityToDTO(c);
    }

    @Override
    public List<categoryDTO> getAll() {
        List<Category> c = cr.findAll();
        List<categoryDTO> clist= c.stream().map(this::entityToDTO)
                .collect(Collectors.toList());
        return  clist;
    }

    @Override
    public categoryDTO getDetailById(int ID) {
        Optional<Category> c =  cr.findById(ID);
        Category category = c.orElseThrow(() -> new ResourceNotFoundException("Category Resource Not Found"));

        // Assuming you have a method to convert Category to CategoryDTO
        return entityToDTO(category);
    }

    public categoryDTO entityToDTO(Category cat){
        return mapper.map(cat,categoryDTO.class);
    }

    public Category dtoToEntity(categoryDTO cat){
        return  mapper.map(cat, Category.class);
    }
}
