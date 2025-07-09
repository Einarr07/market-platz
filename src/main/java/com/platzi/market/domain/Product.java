package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private Integer productId;
    private String productName;
    private int categoryId;
    private double price;
    private int stockQuantity;
    private boolean active;
    private Category category;
}
