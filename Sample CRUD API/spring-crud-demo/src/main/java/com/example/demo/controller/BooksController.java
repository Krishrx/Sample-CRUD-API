package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.service.BooksService;

@RestController
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@GetMapping("/book/getallbooks")
	private List<Books> getAllBooks(){
		return booksService.getAllBooks();
	}
	
	@GetMapping("/book/getbook/{bookid}")
	private Books getBookById(@PathVariable("bookid") int bookId) {
		return booksService.getBooksById(bookId);
	}
	
	@DeleteMapping("/book/delete/{bookid}")
	private String deleteBook(@PathVariable("bookid") int bookId) {
		booksService.delete(bookId);
		return "Successfully Deleted:"+bookId;
	}
	
	@PostMapping("/book/create")  
	private String saveBook(@RequestBody Books books) {  
		booksService.save(books);
		return "Successfully Created:"+books.getBookId();
	}  
  
	@PutMapping("/book/update/{bookid}")  
	private String update(@PathVariable("bookid") int bookId,@RequestBody Books books) { 
		boolean check = booksService.update(bookId,books);  
		if(check) {
			return "Updated Successfully";
		}
		return "Invalid id";
	} 
}
