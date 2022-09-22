package com.vont.java5.models;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotBlank(message = "Product name is mandatory")
    private String name;
    @NotNull(message = "Product price is mandatory")
    private Double price;
    @NotNull(message = "Product quantity is mandatory")
    @Min(value = 1, message = "Product quantity can't lesser than 1")
    private Integer quantity;
}
