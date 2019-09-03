package com.springcloud.server.service.impl;

import com.springcloud.common.ProductOutput;
import com.springcloud.server.mapper.ProductMapper;
import com.springcloud.server.model.Product;
import com.springcloud.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductOutput> productList() {
        return productMapper.findAllProduct();
    }
}
