package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;


public class AdminServiceImple implements AdminService{
	private AdminDAO dao=LMSFactory.getAdminDAO();

	@Override
	public Admin auth(String email, String password) {
		return dao.auth(email, password);
	}

	@Override
	public boolean register(Admin a) {
		return dao.register(a);
	}

	@Override
	public boolean addBook(Book b) {
		return dao.addBook(b);

	}
	@Override
	public boolean issueBooks(User user,Book book) {

		return dao.issueBooks(user,book);
	}

	@Override
	public boolean removeBook(int bookId) {

		return dao.removeBook(bookId);
	}

	@Override
	public int updateBook(int bookId) {

		return dao.updateBook(bookId);
	}

	@Override
	public LinkedList<Book> searchBookByTitle(String bname) {
		return dao.searchBookByTitle(bname);
	}

	@Override
	public LinkedList<Book> searchBookByAuthor(String bauthor) {
		return dao.searchBookByAuthor(bauthor);
	}

	@Override
	public LinkedList<Book> getBooks() {
		return dao.getBooks();
	}

	@Override
	public boolean isBookReceived(User user, Book book) {
		return dao.isBookReceived(user, book);
	}

	@Override
	public LinkedList<Book> searchBookByCategory(String category) {
		return dao.searchBookByCategory(category);
	}

	@Override
	public List<RequestBean> showRequests() {
		return dao.showRequests();
	}

	@Override
	public List<User> showUsers() {
		return dao.showUsers();
	}
	


}
