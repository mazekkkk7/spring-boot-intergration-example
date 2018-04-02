package cn.mazekkkk.product.elasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * 分页和排序仓储对象
 *
 * @author maze
 * @createTime 18/3/30
 */
public interface BookRepository<Book, ID extends Serializable> extends CrudRepository<Book, ID> {

    /**
     * 查询所有并排序
     *
     * @param sort 排序条件
     * @return
     */
    Iterable<Book> findAll(Sort sort);

    /**
     * 查询所有并分页
     *
     * @param pageable 分页对象
     * @return
     */
    Page<Book> findAll(Pageable pageable);

}
