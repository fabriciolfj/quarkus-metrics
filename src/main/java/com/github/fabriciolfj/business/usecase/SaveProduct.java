package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ProviderSaveProduct;
import com.github.fabriciolfj.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class SaveProduct {

    private final ProviderSaveProduct provider;

    public Product execute(final Product product) {
        log.info("Product save: {}", product);
        product.setCode(UUID.randomUUID().toString());
        provider.save(product);

        return product;
    }
}
