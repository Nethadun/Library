package com.ijse.libSystem.repository.custom;


import com.ijse.libSystem.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> search(String searchText, Integer count, Integer page);
}
