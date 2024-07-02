package com.onlineStore.EStore.Controller;

import com.onlineStore.EStore.DTO.productDTO;
import com.onlineStore.EStore.Service.Impl.productServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class product {

    @Autowired
    public productServiceImpl ps;
    @GetMapping("/test")
    public String test(){
        return "product tested";
    }

   @GetMapping("/save")
    public productDTO createProduct(@RequestBody productDTO p){
        return ps.createProduct(p);
    }


    @GetMapping("/all")
    public List<productDTO> getAll(){
        return ps.getAll();
    }
}
