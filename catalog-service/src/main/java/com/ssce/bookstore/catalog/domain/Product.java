package com.ssce.bookstore.catalog.domain;

import java.math.BigDecimal;

public record Product(String code, String name, String description, String image_url, BigDecimal price) {}
