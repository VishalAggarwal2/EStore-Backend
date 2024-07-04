package com.onlineStore.EStore.Controller;

import com.onlineStore.EStore.DTO.categoryDTO;
import com.onlineStore.EStore.DTO.productDTO;
import com.onlineStore.EStore.Service.Impl.catyegoryServicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public catyegoryServicImpl cs;

    @GetMapping("/test")
    public  String  test(){
        return "testes";
    }

    @GetMapping("/createCategory")
    categoryDTO creatCategory(@RequestBody categoryDTO cat){
   return  cs.createCategory(cat);
    }


    @GetMapping("/getall")
    List<categoryDTO> getAll()
    {
        return cs.getAll();
    }

    @GetMapping("/id")
    categoryDTO getById(@RequestBody int id){
        return cs.getDetailById(id);
    }


    @GetMapping("/{cid}/addproduct")
    productDTO getById(@RequestBody productDTO product, @PathVariable int cid){
        System.out.println("called added");
        return cs.createProductAndCategory(product,cid);
    }
    @GetMapping("/{cid}/allproducts")
    List<productDTO> getAllProducts(@PathVariable int cid){
        System.out.println("called get");
        return cs.getAllProducts(cid);
    }
}
