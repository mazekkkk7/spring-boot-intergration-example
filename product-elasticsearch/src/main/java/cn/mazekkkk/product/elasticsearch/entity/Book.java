package cn.mazekkkk.product.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 书实体
 *
 * @author maze
 * @createTime 18/3/30
 */
@Document(indexName = "library",type = "book")
@Data
public class Book implements Serializable {
    @Id
    private String _id;
    /**
     * 书名
     */
    private String name;
    /**
     * 书单价
     */
    private Double price;
}
