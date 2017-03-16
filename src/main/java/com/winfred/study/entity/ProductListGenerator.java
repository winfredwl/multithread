package com.winfred.study.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Winfred
 * @since 2017/3/16
 */
public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product" + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
