package com.LibraryManagement.Repository;

import com.LibraryManagement.Entity.BooksEntity;
import com.LibraryManagement.dto.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends CrudRepository<BooksEntity, Long> {
}
