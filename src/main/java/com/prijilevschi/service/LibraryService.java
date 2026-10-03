package com.prijilevschi.service;

import com.prijilevschi.dto.BookDTO;
import com.prijilevschi.entity.BookEntity;
import com.prijilevschi.repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {}

    public Long addBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(bookDTO.name());
        return libraryRepository.save(bookEntity).getId();
    }

    public void borrowBook(String id) {
        libraryRepository.findById(Long.parseLong(id))
                .ifPresent(book -> {
                    book.setBorrowed(true);
                    libraryRepository.save(book);
                });
    }

    public void returnBook(String id) {
        libraryRepository.findById(Long.parseLong(id))
                .ifPresent(book -> {
                    book.setBorrowed(false);
                    libraryRepository.save(book);
                });
    }



    @Transactional(readOnly = true)
    public List<BookDTO> getBorrowedBooks() {
        return Optional.ofNullable(libraryRepository.findByIsBorrowed(true)).orElse(Collections.emptyList())
                .stream()
                .map(bookEntity -> new BookDTO(bookEntity.getId(), bookEntity.getName(), bookEntity.getBorrowed()))
                .toList();
    }
}
