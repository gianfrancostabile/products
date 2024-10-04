package com.ar.gfstabile.products.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public record PriceDto(
        @JsonProperty("code") @NotBlank(message = "code cannot be blank") String code,
        @JsonProperty("price") Double price) implements Serializable {

}
