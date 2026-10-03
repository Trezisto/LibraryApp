package com.prijilevschi.controller;

import com.prijilevschi.dto.BookDTO;
import com.prijilevschi.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO) {
        libraryService.addBook(bookDTO);
    }
    @PatchMapping("/{id}/borrow")
    public void borrowBook(@PathVariable String id) {
        libraryService.borrowBook(id);
    }

    @PatchMapping("/{id}/return")
    public void returnBook(@PathVariable String id) {
        libraryService.returnBook(id);
    }

    @GetMapping("/borrowed")
    public List<BookDTO> getBorrowedBooksList() {
        return libraryService.getBorrowedBooks();
    }

}
