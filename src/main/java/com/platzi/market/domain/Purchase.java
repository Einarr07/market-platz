package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class Purchase {

    private Integer purchaseId;
    private String clienteId;
    private LocalDateTime purchaseDate;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> item;
}
