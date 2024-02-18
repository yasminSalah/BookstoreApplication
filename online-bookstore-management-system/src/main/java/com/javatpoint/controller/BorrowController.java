package com.javatpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatpoint.model.Borrowing;
import com.javatpoint.service.BorrowingService;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/{bookId}")
    public Borrowing borrowBook(@PathVariable Long bookId, @RequestParam Long userId) {
        return borrowingService.borrowBook(bookId, userId);
    }

    @PutMapping("/{borrowingId}")
    public void returnBook(@PathVariable Long borrowingId) {
        borrowingService.returnBook(borrowingId);
    }
}

