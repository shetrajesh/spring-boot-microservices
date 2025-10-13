package com.ssce.bookstore.catalog.web.controllers;

import com.ssce.bookstore.catalog.domain.PagedResult;
import com.ssce.bookstore.catalog.domain.Product;
import com.ssce.bookstore.catalog.domain.ProductService;
import com.ssce.bookstore.catalog.web.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{pcode}")
    ResponseEntity<Product> getProductByCode(@PathVariable String pcode) {

        return productService
                .getProductByCode(pcode)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(pcode));
    }
}
