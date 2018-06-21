package com.framgia.sqssender.dto;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

@Data
@JsonSnakeCase
public class BaseDTO {
    private boolean status;
    private String message;
    private Object data;
}
