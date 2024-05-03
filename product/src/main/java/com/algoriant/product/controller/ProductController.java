package com.algoriant.product.controller;


import com.algoriant.product.model.*;
import com.algoriant.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PreAuthorize("hasAnyAuthority('STOCK_MANAGER')")
    @PostMapping("/createProducts")
    public ResponseEntity<Product> createProducts(@RequestBody ProductRequest request) {
        Product product = service.createProducts(request);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('STOCK_MANAGER')")
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    }
    @PreAuthorize("hasAnyAuthority('STOCK_MANAGER')")
    @GetMapping("/getProductByIds/{productId}")
    public ResponseEntity<Product> getProductByIds(@PathVariable BigInteger productId) {
        return new ResponseEntity<>(service.getProductById(productId),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('STOCK_MANAGER')")
    @DeleteMapping("/deleteProductByIds/{productId}")
    public ResponseEntity<String> deleteProductByIds(@PathVariable BigInteger productId) {
        service.deleteProductById(productId);
        return  new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('STOCK_MANAGER')")
    @PutMapping("/updateProducts/{productId}")
    public ResponseEntity<String> updateProducts(@PathVariable("productId") BigInteger productId, @RequestBody ProductDto productDto) {
        service.updateProduct(productId,productDto.getProductName(), productDto.getDescription(), productDto.getPrice(), productDto.getCategory());
        return new ResponseEntity<>("product updated",HttpStatus.OK);
    }
}
