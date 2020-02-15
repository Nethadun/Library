package com.ijse.libSystem.repository.custom.impl;



import com.ijse.libSystem.entity.Book;
import com.ijse.libSystem.repository.custom.BookRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BookRepositoryCustomImpl implements BookRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Book> search(String searchText, Integer count, Integer page) {
        Query q=entityManager.createNativeQuery("select b.* from book b where (b.book_title like :searchText ) and b.is_enable=1", Book.class);
        q.setParameter("searchText","%"+ searchText + "%");
        q.setFirstResult(page * count);
        q.setMaxResults(count);
        return q.getResultList();
    }
}
