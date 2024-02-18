package com.javatpoint.service;
import java.util.List;

import com.javatpoint.model.Book;

public interface BookService {

	List<Book> getAllBooks();
    Book getBookById(Long id);
    Book addBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}
