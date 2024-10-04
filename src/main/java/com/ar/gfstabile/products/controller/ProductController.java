package com.ar.gfstabile.products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.gfstabile.products.dto.PriceDto;
import com.ar.gfstabile.products.dto.ProductDto;
import com.ar.gfstabile.products.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProductDto request) {
        service.create(request);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductDto> findByCode(@PathVariable String code) {
        Optional<ProductDto> result = service.findByCode(code);
        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{code}/price")
    public ResponseEntity<PriceDto> getPriceByCode(@PathVariable String code) {
        Optional<PriceDto> result = service.getPriceByCode(code);
        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }
}
