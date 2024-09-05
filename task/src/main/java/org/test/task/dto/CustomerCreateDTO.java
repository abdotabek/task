package org.test.task.dto;

import jakarta.validation.constraints.NotBlank;

public class CustomerCreateDTO {
    @NotBlank
    private String name;

    public @NotBlank String getName() {
        return name;
    }
}
