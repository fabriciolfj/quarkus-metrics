package com.github.fabriciolfj.entrypoint.converter;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entrypoint.dto.ProductRequest;
import com.github.fabriciolfj.entrypoint.dto.ProductResponse;

public class ProductDtoConverter {

    private ProductDtoConverter() { }

    public static final Product toEntity(final ProductRequest request) {
        return Product
                .builder()
                .name(request.getName())
                .build();
    }

    public static final ProductResponse toResponse(final Product product) {
        return ProductResponse
                .builder()
                .code(product.getCode())
                .name(product.getName())
                .build();
    }
}
