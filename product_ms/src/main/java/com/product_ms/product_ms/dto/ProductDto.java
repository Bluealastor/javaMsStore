package com.product_ms.product_ms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {


    private String id;

    @NotBlank(message = "Il nome è obbligatorio")
    private String name;

    @NotBlank(message = "La descrizione è obbligatoria")
    @Size(max = 255, message = "MAX descrizione 255 caratteri")
    private String description;

    @NotNull(message = "Il prezzo è obbligatorio")
    @Min(value = 0, message = "Il prezzo deve essere maggiore o uguale a 0")
    private Double price;

}
