package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.business.usecase.FindProduct;
import com.github.fabriciolfj.business.usecase.SaveProduct;
import com.github.fabriciolfj.entrypoint.converter.ProductDtoConverter;
import com.github.fabriciolfj.entrypoint.dto.ProductRequest;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final SaveProduct saveProduct;
    private final FindProduct findProduct;

    @POST
    public Response create(final ProductRequest request) {
        var product= saveProduct.execute(ProductDtoConverter.toEntity(request));
        return Response.status(Response.Status.CREATED)
                .entity(product)
                .build();
    }

    @GET
    @Path("/{code}")
    public Response findCode(@PathParam("code") final String code) {
        var product = findProduct.execute(code);
        return Response.status(Response.Status.OK)
                .entity(product)
                .build();
    }
}
