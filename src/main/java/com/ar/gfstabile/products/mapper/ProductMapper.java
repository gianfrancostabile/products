package com.ar.gfstabile.products.mapper;

import org.mapstruct.Mapper;

import com.ar.gfstabile.products.dto.PriceDto;
import com.ar.gfstabile.products.dto.ProductDto;
import com.ar.gfstabile.products.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto map(Product product);

    Product map(ProductDto product);

    PriceDto mapPrice(Product product);
}
