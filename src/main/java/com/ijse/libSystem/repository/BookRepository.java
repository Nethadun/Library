package com.ijse.libSystem.repository;


import com.ijse.libSystem.entity.Book;
import com.ijse.libSystem.repository.custom.BookRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
}
