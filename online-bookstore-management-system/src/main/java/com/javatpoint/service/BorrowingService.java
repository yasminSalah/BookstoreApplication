package com.javatpoint.service;

import com.javatpoint.model.Borrowing;

public interface BorrowingService {

	Borrowing borrowBook(Long bookId, Long userId);
    void returnBook(Long borrowingId);
}
