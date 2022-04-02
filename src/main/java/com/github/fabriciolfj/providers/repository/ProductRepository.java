package com.github.fabriciolfj.providers.repository;

import com.github.fabriciolfj.providers.repository.data.ProductData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductData> {

    public Optional<ProductData> findByCode(final String code) {
        return find("code", code).stream().findFirst();
    }
}
