package com.growdane.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author growdane@gmail.com
 * @date 2020-02-04 20:25
 */


@Data
@AllArgsConstructor
@ToString
public class Cart {
    private String id;
    private String cartPFilename;
    private String cartPName;
    private Float cartPPrice;
    private String cartQuantity;
    private Float cartPStock;
    private String cartPId;
    private String cartUId;
    private String cartValid;
}
