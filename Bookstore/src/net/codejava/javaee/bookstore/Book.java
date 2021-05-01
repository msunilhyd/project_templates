package net.codejava.javaee.bookstore;

public class Book {

	protected int id;
	protected String title;
	protected String author;
	protected float price;
	protected String status;
	protected int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Book() {
		
	}
	
	public Book (int id) {
		this.id = id;
	}
	
	public Book(int id, String title, String author, float price) {
		this(title, author, price);
		this.id = id;
	}
	
	public Book(String title, String author, float price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public Book(int id, String title, String author, float price, String status) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.status = status;
	}
	
	public Book(String title, String author, float price, int userId) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.userId = userId;
	}
	
	public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public float getPrice() {
        return price;
    }
 
    public void setPrice(float price) {
        this.price = price;
    }
}
