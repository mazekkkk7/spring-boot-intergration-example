package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.elasticsearch.entity.Book;
import cn.mazekkkk.product.elasticsearch.repository.BookRepository;
import cn.mazekkkk.product.service.BookService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * elasticsearch bookRepository 索引 demo 实现类
 *
 * @author maze
 * @createTime 18/3/30
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TransportClient transportClient;

    /**
     * 查询单个图书对象
     *
     * @return
     */
    @Override
    public Book bookMatchOne() {
        return bookRepository.findOne("1001");
    }

    @Override
    public Page<Book> bookMatchAll() {
        Pageable pageable = new PageRequest(0,20);
        return bookRepository.findAll(pageable);
    }
}
