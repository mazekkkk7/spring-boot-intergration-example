package cn.mazekkkk.product.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 书实体
 *
 * @author maze
 * @createTime 18/3/30
 */
@Document(indexName = "libary",type = "book")
@Data
public class Book implements Serializable {
    /**
     * 书名
     */
    private String name;
    /**
     * 书单价
     */
    private BigDecimal price;
}
