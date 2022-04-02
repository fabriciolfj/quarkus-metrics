package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.ProviderFindProduct;
import com.github.fabriciolfj.business.ProviderSaveProduct;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.providers.repository.ProductRepository;
import com.github.fabriciolfj.providers.repository.converter.ProductDataConverter;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductProvider implements ProviderSaveProduct, ProviderFindProduct {

    private final ProductRepository productRepository;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void save(Product product) {
        productRepository.persist(ProductDataConverter.toData(product));
    }

    @Override
    public Product findCode(final String code) {
        return productRepository.findByCode(code)
                .map(ProductDataConverter::toEntity)
                .orElseThrow(() -> new RuntimeException("Product not found: " + code));
    }
}
