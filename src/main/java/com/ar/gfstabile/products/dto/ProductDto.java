package com.ar.gfstabile.products.dto;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
public record ProductDto(
        @JsonProperty("code") @NotBlank(message = "code cannot be blank") String code,
        @JsonProperty("name") @NotBlank(message = "name cannot be blank") String name,
        @JsonProperty("description") String description,
        @JsonProperty("price") @NotNull(message = "price cannot be null") @Min(value = 0, message = "price cannot be less than 0") Double price)
        implements Serializable {

}
