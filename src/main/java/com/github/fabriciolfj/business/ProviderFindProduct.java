package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Product;

public interface ProviderFindProduct {

    Product findCode(final String code);
}
