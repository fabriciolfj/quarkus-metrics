package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ProviderFindProduct;
import com.github.fabriciolfj.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FindProduct {

    private final ProviderFindProduct provider;

    public Product execute(final String code) {
        log.info("Find by code {}", code);
        return provider.findCode(code);
    }
}
