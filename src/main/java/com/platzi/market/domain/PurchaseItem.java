package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PurchaseItem {

    private Integer productId;
    private int quantity;
    private Double total;
    private boolean active;
}
