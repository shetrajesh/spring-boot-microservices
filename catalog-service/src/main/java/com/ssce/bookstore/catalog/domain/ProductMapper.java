package com.ssce.bookstore.catalog.domain;

class ProductMapper {
    static Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImage_url(),
                productEntity.getPrice());
    }

    static ProductEntity toProductEntity(Product product) {
        return new ProductEntity(
                0L, product.code(), product.name(), product.description(), product.image_url(), product.price());
    }
}
