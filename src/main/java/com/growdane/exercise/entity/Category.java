package com.growdane.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 16:36
 */

@Data
@ToString
@AllArgsConstructor
public class Category {
    private String id;
    private String categoryName;
    private String categoryParentId;
}
