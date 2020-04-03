package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;



public class Book implements Serializable  {
	private int bookId;
	private String bookName;
	private String bookPublications;
	private String authorName;
	private String category;
	private String issuedate;
	private String returndate;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPublications() {
		return bookPublications;
	}
	public void setBookPublications(String bookPublications) {
		this.bookPublications = bookPublications;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	
	
	
	

}
