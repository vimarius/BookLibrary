package lt.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private ArrayList<Book> userBooks;

	public User(Long id, ArrayList<Book> userBooks) {
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

	public void setUserBooks(ArrayList<Book> userBooks) {
		this.userBooks = userBooks;
	}

}
