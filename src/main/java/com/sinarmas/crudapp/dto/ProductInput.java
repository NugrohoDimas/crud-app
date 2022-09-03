package com.sinarmas.crudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInput {
    @NotNull(message = "Field harus diisi!")
    @Size(max = 100, message = "Panjang field tidak boleh lebih dari 100 huruf")
    private String name;

    @NotNull(message = "Field harus diisi!")
    private Integer price;

    @NotNull(message = "Field harus diisi!")
    private Integer category;
}
