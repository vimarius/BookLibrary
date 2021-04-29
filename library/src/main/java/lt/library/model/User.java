package lt.library.model;

import java.util.List;

public class User {

	private Long id;
	private List<Book> userBooks;

	public User(Long id, List<Book> userBooks) {
		this.id = id;
		this.userBooks = userBooks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Book> getUserBooks() {
		return userBooks;
	}

	public void setUserBooks(List<Book> userBooks) {
		this.userBooks = userBooks;
	}

}
