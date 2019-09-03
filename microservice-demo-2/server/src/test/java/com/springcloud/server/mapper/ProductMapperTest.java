package com.springcloud.server.mapper;

import com.springcloud.common.ProductOutput;
import com.springcloud.server.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void findById() {
        Product product = productMapper.findById(1);
        log.info(product.getProductName() + " : " + product.getProductPNum());
    }

    @Test
    public void findAllProduct() {

        List<ProductOutput> productList = new ArrayList<>();
        productList = productMapper.findAllProduct();
        System.out.println();

    }
}