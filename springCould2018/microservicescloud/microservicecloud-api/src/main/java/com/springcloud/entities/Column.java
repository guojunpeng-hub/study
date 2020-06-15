package com.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data  // 此为setget的注解
@Accessors(chain = true)
public class Column  implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 排序
     */
    private Integer columnOrder;
}
