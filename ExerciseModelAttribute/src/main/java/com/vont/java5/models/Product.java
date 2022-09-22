package com.vont.java5.models;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotBlank(message = "Product name is mandatory")
    private String name;
    @NotBlank(message = "Product price is mandatory")
    @Pattern(regexp = "\\d+(\\.\\d*)?", message = "Product price must be number")
    private String price;
    @NotBlank(message = "Product quantity is mandatory")
    @Min(value = 1, message = "Product quantity can't lesser than 1")
    @Pattern(regexp = "^[0-9]*$", message = "Product quantity must be number")
    private String quantity;
    private Double total;

    private Date date;

    public Double getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = Double.parseDouble(this.price) * Integer.parseInt(this.quantity);
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {

        this.date = new Date();
    }
}
