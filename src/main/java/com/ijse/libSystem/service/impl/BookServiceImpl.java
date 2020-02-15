package com.ijse.libSystem.service.impl;



import com.ijse.libSystem.builder.DtoBuilder;
import com.ijse.libSystem.builder.EntityBuilder;
import com.ijse.libSystem.dto.BookDto;
import com.ijse.libSystem.entity.Book;
import com.ijse.libSystem.repository.BookRepository;
import com.ijse.libSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    DtoBuilder dtoBuilder;
    @Override
    public Long add(BookDto bookDto) {
        Book saved=bookRepository.save(entityBuilder.buildBookEntity(new Book(), bookDto));
        return null !=saved ? saved.getBid() : null;
    }

    @Override
    public Long update(BookDto bookDto) {
        Book saved=bookRepository.save(entityBuilder.buildBookEntity(new Book(), bookDto));
        return null !=saved ? saved.getBid() : null;
    }

    @Override
    public List<BookDto> searchLike(String searchText, Integer count, Integer page) {
        List<BookDto> list= new ArrayList<>();

        for (Book entity : bookRepository.search(searchText, count,page)){
            list.add(dtoBuilder.buildBookDto(entity));
        }
        return list;
    }

    @Override
    public BookDto get(Long id) {
        return dtoBuilder.buildBookDto(bookRepository.getOne(id));
    }

    @Override
    public Long delete(Long id) {
        Book book=bookRepository.getOne(id);
        book.setIsEnable(0);
        Book saved= bookRepository.save(book);

        return null !=saved.getBid() ? saved.getBid():null;
    }
}
