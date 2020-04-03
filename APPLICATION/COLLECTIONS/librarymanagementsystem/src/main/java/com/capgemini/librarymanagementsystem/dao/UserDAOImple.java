package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;

import org.omg.CORBA.UserException;

import com.capgemini.librarymanagementsystem.db.BookDatabase;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class UserDAOImple implements UserDAO {

	@Override
	public boolean registerUser(User user) {
		for(User u:BookDatabase.user) {
			if(u.getuEmail().equals(user.getuEmail())) {
				return false;
			}
		}
		BookDatabase.user.add(user);
		return true;
	}


	@Override
	public User authUser(String email, String password) {
		for(User u1:BookDatabase.user) {
			if(u1.getuEmail().equals(email) && u1.getuPassword().equals(password)) {
				return u1;
			}
		}

		throw new LMSException("Unauthorized User");

	}

	

	@Override
	public LinkedList<Book> searchBookByTitle(String bname) {
		LinkedList<Book> searchList=new LinkedList<Book>();
		for(int i=0;i<=BookDatabase.book.size()-1;i++)
		{
			Book retrievedBook=BookDatabase.book.get(i);
			String retrievedBname=retrievedBook.getBookName();
			if(bname.equals(retrievedBname))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}

	}
	@Override
	public LinkedList<Book> searchBookByAuthor(String bAuthor) {
		LinkedList<Book> searchList=new LinkedList<Book>();
		for(int i=0;i<=BookDatabase.book.size()-1;i++)
		{
			Book retrievedBook=BookDatabase.book.get(i);
			String retrievedBAuthor=retrievedBook.getAuthorName();
			if(bAuthor.equals(retrievedBAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}	
	}



	@Override
	public LinkedList<Book> getBooksInfo() {
		return BookDatabase.book;
	}


	@Override
	public RequestBean bookRequest(User user, Book book) {
		boolean flag = false, 
				isRequestExists = false;
		RequestBean requestInfo = new RequestBean();
		User userInfo2 = new User();
		Book bookInfo2 = new Book();

		for (RequestBean requestInfo2 : BookDatabase.REQUEST) {
			if (book.getBookId() == requestInfo2.getBookInfo().getBookId()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (User userBean : BookDatabase.user) {
				if (user.getuId() == userBean.getuId()) {
					for (Book book1 : BookDatabase.book) {
						if (book1.getBookId() == book1.getBookId()) {
							userInfo2 = userBean;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setUserInfo(userInfo2);;
				BookDatabase.REQUEST.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LMSException("Invalid request or you cannot request that book");

	}


	@Override
	public RequestBean bookReturn(User user, Book book) {
		for (RequestBean requestInfo : BookDatabase.REQUEST) {

			if (requestInfo.getBookInfo().getBookId() == book.getBookId() &&
					requestInfo.getUserInfo().getuId() == user.getuId() &&
					requestInfo.isIssued() == true) {


				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);


				return requestInfo;
			}

		}

		throw new  LMSException("Invalid return ");
	}


	@Override
	public LinkedList<Book> searchBookByCategory(String category) {
		LinkedList<Book> searchList=new LinkedList<Book>();
		for(int i=0;i<=BookDatabase.book.size()-1;i++)
		{
			Book retrievedBook=BookDatabase.book.get(i);
			String retrievedCategory=retrievedBook.getCategory();
			if(category.equals(retrievedCategory))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}	
	}
}






