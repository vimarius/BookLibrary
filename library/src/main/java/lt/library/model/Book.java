package lt.library.model;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID guid;
	private String name;
	private String author;
	private String category;
	private String Language;
	private int publicationDate;
	private String isbn;
	private BookStatus status;

	public Book(UUID guid, String name, String author, String category, String language, int publicationDate,
			String isbn, BookStatus status) {
		this.guid = guid;
		this.name = name;
		this.author = author;
		this.category = category;
		Language = language;
		this.publicationDate = publicationDate;
		this.isbn = isbn;
		this.status = status;
	}

	public UUID getGuid() {
		return guid;
	}

	public void setGuid(UUID guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public int getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(int publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

}
