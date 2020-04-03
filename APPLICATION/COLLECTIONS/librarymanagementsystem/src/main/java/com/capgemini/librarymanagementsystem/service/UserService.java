package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface UserService {
	boolean registerUser(User user);
	User authUser(String email,String password);
	public RequestBean bookRequest(User user, Book book);
	public RequestBean bookReturn(User user, Book book);	
	//Book borrow(int bookId);
	LinkedList<Book> searchBookByTitle(String bname);
	LinkedList<Book> searchBookByAuthor(String bAuthor);
	LinkedList<Book> searchBookByCategory(String category);
	LinkedList<Book> getBooksInfo();

}
