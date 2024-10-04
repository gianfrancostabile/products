package com.ar.gfstabile.products.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ar.gfstabile.products.dto.PriceDto;
import com.ar.gfstabile.products.dto.ProductDto;
import com.ar.gfstabile.products.mapper.ProductMapper;
import com.ar.gfstabile.products.model.Product;
import com.ar.gfstabile.products.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper productMapper;

    public void create(ProductDto request) {
        if (repository.existsByCode(request.code())) {
            throw new Error("product code already exist");
        }
        Product product = productMapper.map(request);
        repository.save(product);
    }

    public Optional<ProductDto> findByCode(String code) {
        if (!StringUtils.hasText(code)) {
            throw new Error("code is required");
        }
        return repository.findByCode(code).map(productMapper::map);
    }

    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(productMapper::map).collect(Collectors.toList());
    }

    public Optional<PriceDto> getPriceByCode(String code) {
        if (!StringUtils.hasText(code)) {
            throw new Error("code is required");
        }
        return repository.findByCode(code).map(productMapper::mapPrice);
    }
}
