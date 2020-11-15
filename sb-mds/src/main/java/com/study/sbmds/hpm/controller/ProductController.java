package com.study.sbmds.hpm.controller;

import com.study.sbmds.hpm.dao.ds1.ProductJpaRepository;
import com.study.sbmds.hpm.entity.ds1.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/23 15:45
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductJpaRepository productJpaRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productJpaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productJpaRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<List<Product>> addProduct(@RequestBody List<Product> products){
        return ResponseEntity.ok(productJpaRepository.saveAll(products));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        productJpaRepository.deleteById(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok(productJpaRepository.save(product));
    }
}
