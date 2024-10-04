package com.ar.gfstabile.products.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ar.gfstabile.products.model.Product;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {

    Optional<Product> findByCode(String code);
    boolean existsByCode(String code);
}
