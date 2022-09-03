package com.sinarmas.crudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInput {
    @NotEmpty(message = "Field harus diisi!")
    @Size(max = 50, message = "Panjang field tidak boleh lebih dari 100 huruf")
    private String name;
}
