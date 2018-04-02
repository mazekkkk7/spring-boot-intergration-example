//package cn.mazekkkk.product.service.impl;
//
//import cn.mazekkkk.product.elasticsearch.entity.Book;
//import cn.mazekkkk.product.elasticsearch.repository.BookRepository;
//import cn.mazekkkk.product.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
///**
// * elasticsearch book 索引 demo 实现类
// *
// * @author maze
// * @createTime 18/3/30
// */
//@Service
//public class BookServiceImpl implements BookService {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    /**
//     * 匹配全部书
//     *
//     * @param page 当前第几页
//     * @param size 页长
//     * @return
//     */
//    @Override
//    public Page<Book> bookMatchAll(Integer page, Integer size) {
//        return bookRepository.findAll(new PageRequest(1,20));
//    }
//}
