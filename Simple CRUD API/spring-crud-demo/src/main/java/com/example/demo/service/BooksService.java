package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;

@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksRepository;
	
	public List<Books> getAllBooks(){
		ArrayList<Books>books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}
	
	public Books getBooksById(int id) {
		return booksRepository.findById(id).get();
	}
	
	public void save(Books book) {
		booksRepository.save(book);
	}
	
	public void delete(int id) {
		booksRepository.deleteById(id);
	}
	
	public boolean update(int id,Books book) {
		Books existingBook = booksRepository.findById(id).orElse(null);
		if(existingBook!=null) {
			existingBook.setBookId(id);
			existingBook.setBookName(book.getBookName());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setPrice(book.getPrice());
			booksRepository.save(existingBook);
			return true;
		}
		return false;
	}
	
}
