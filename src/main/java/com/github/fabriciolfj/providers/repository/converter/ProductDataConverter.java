package com.github.fabriciolfj.providers.repository.converter;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.providers.repository.data.ProductData;

public class ProductDataConverter {

    private ProductDataConverter() { }

    public static ProductData toData(final Product product) {
        return ProductData.builder()
                .code(product.getCode())
                .name(product.getName())
                .build();
    }

    public static Product toEntity(final ProductData productData) {
        return Product
                .builder()
                .code(productData.getCode())
                .name(productData.getName())
                .build();
    }
}
