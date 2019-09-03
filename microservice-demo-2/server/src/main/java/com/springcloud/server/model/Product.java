package com.springcloud.server.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Product {

    private Integer id;
    private String productName;
    private int productPNum;


}
