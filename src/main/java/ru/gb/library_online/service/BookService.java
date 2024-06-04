package ru.gb.library_online.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.library_online.model.Book;
import ru.gb.library_online.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }
}
