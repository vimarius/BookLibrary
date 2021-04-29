package lt.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lt.library.command.BookCommand;
import lt.library.exceptions.ResourceNotFoundException;
import lt.library.model.Book;
import lt.library.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public void addABook(BookCommand addedBook) {
		Book book = new Book();
		book.setName(addedBook.getName());
		book.setAuthor(addedBook.getAuthor());
		book.setCategory(addedBook.getCategory());
		book.setLanguage(addedBook.getLanguage());
		book.setPublicationDate(addedBook.getPublicationDate());
		book.setIsbn(addedBook.getIsbn());
		book.setStatus(addedBook.getStatus());
		bookRepository.save(book);

	}

	public ResponseEntity<Book> getBookByGUID(Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book with GUID: " + id + " does not exist."));

		return ResponseEntity.ok(book);

	}

	public List<Book> filterByAuthor(String author) {

		return bookRepository.filterByAuthor(author);
	}
}
