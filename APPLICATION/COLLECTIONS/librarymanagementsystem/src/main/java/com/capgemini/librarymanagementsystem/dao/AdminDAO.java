package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface AdminDAO {
	Admin auth(String email,String password);
	boolean register(Admin a);
	boolean addBook(Book b);
	boolean issueBooks(User user,Book book);
	boolean removeBook(int bookId);
	int updateBook(int bookId);
	LinkedList<Book> searchBookByTitle(String bname);
	LinkedList<Book> searchBookByAuthor(String bauthor);
	LinkedList<Book> searchBookByCategory(String category);
	LinkedList<Book> getBooks();
	boolean isBookReceived(User user,Book book);
	List<RequestBean> showRequests();
	List<User> showUsers();

	

}
