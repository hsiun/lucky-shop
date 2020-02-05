package com.growdane.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author growdane@gmail.com
 * @date 2020-02-03 18:09
 */

@AllArgsConstructor
@Data
@ToString
public class Product {
    private String id;
    private String productName;
    private String productDes;
    private float productPrice;
    private float productStock;
    private String productFid;
    private String productCid;
    private String productFilename;
}
