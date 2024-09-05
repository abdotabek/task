package org.test.task.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank
    private String name;
    @Min(value = 0)
    private Integer price;
    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Min(value = 0) Integer getPrice() {
        return price;
    }

    public void setPrice(@Min(value = 0) Integer price) {
        this.price = price;
    }


}
