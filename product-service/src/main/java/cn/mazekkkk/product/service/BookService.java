package cn.mazekkkk.product.service;

import cn.mazekkkk.product.elasticsearch.entity.Book;
import org.springframework.data.domain.Page;


/**
 * elasticsearch book 索引 demo
 *
 * @author maze
 * @creatme 18/3/30
 */
public interface BookService {

    /**
     * 查询单个图书对象
     *
     * @return
     */
    Book bookMatchOne();

    /**
     * 匹配所有图书 分页查询
     *
     * @return
     */
    Page<Book> bookMatchAll();

}
