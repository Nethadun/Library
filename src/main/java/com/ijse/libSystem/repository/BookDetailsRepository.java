package com.ijse.libSystem.repository;

import com.ijse.libSystem.entity.BookDetails;
import com.ijse.libSystem.repository.custom.BookDetailsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailsRepository extends JpaRepository<BookDetails,Long>, BookDetailsRepositoryCustom {
}
