package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;

public class UserServiceImple implements UserService {
	private UserDAO dao=LMSFactory.getUserDAO();

	@Override
	public boolean registerUser(User user) {
		return dao.registerUser(user);
		
	}

	@Override
	public User authUser(String email, String password) {
		return dao.authUser(email, password);
		
	}

	@Override
	public LinkedList<Book> searchBookByTitle(String bname) {
		return dao.searchBookByTitle(bname);
	}

	@Override
	public LinkedList<Book> searchBookByAuthor(String bAuthor) {
		return dao.searchBookByAuthor(bAuthor);
	}

	@Override
	public LinkedList<Book> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public RequestBean bookRequest(User user, Book book) {
		return dao.bookRequest(user, book);
	}

	@Override
	public RequestBean bookReturn(User user, Book book) {
		return dao.bookReturn(user, book);
	}

	@Override
	public LinkedList<Book> searchBookByCategory(String category) {
		return dao.searchBookByCategory(category);
	}

	
	

}
