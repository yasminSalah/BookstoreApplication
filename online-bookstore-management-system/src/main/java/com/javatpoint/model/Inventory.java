package com.javatpoint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Inventory {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @OneToOne
	    @JoinColumn(name = "book_id")
	    private Book book;
	    
	    private int stockLevel;
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Book getBook() {
			return book;
		}
		public void setBook(Book book) {
			this.book = book;
		}
		public int getStockLevel() {
			return stockLevel;
		}
		public void setStockLevel(int stockLevel) {
			this.stockLevel = stockLevel;
		}
		

}
