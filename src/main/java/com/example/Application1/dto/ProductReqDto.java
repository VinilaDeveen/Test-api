package com.example.Application1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReqDto {
    private String name;
    private Double price;
    private String description;
    private Long categoryID;
}
