package com.sinarmas.crudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData <T>{
    private T payload;
    private boolean status;
    private String message;
}
