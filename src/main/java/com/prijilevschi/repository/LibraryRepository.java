package com.prijilevschi.repository;


import com.prijilevschi.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByIsBorrowed(boolean isBorrowed);
}
