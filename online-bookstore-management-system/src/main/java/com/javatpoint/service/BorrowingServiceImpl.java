package com.javatpoint.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapoint.repository.BookRepository;
import com.javapoint.repository.BorrowingRepository;
import com.javapoint.repository.UserRepository;
import com.javatpoint.exception.BookNotAvailableException;
import com.javatpoint.exception.ResourceNotFoundException;
import com.javatpoint.model.Book;
import com.javatpoint.model.Borrowing;
import com.javatpoint.model.User;

@Service
public class BorrowingServiceImpl implements BorrowingService{

	@Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Borrowing borrowBook(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book is not available for borrowing");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Borrowing borrowing = new Borrowing();
        borrowing.setBook(book);
        borrowing.setUser(user);
        borrowing.setBorrowedDate(LocalDate.now());
        // Set return date as 2 weeks from borrowed date
        borrowing.setReturnDate(LocalDate.now().plusWeeks(2));

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowingRepository.save(borrowing);
    }

    public void returnBook(Long borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing", "id", borrowingId));

        borrowing.getBook().setAvailable(true);
        borrowing.setReturnDate(LocalDate.now());

        borrowingRepository.save(borrowing);
    }
}
