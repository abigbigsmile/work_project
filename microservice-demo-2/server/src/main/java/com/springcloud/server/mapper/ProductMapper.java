package com.springcloud.server.mapper;

import com.springcloud.common.ProductOutput;
import com.springcloud.server.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {

    @Results(
            id = "ProductBaseResultMap",
            value = {
                    @Result(id = true, property = "productName", column = "product_name"),
                    @Result(property = "productPNum", column = "product_num")
            }
    )

    @Select("select * from product where id = #{id}")
    public Product findById(Integer id);

    @Insert("insert into product(product_name, product_num) values(#{product.productName}, #{product.productNum})")
    public int insert(Product product);

    @Select("select * from product")
    @ResultMap("ProductBaseResultMap")
    public List<ProductOutput> findAllProduct();
}
