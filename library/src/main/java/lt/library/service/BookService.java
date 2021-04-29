package lt.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lt.library.command.BookCommand;
import lt.library.exceptions.ResourceNotFoundException;
import lt.library.model.Book;
import lt.library.model.User;
import lt.library.repository.BookRepository;
import lt.library.repository.UserRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	private UserRepository userRepository;

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

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);

	}

	public ResponseEntity<Book> takeABook(Long id, Long userId, int timeInMonths, Book bookToTake) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist."));

		if (user != null && timeInMonths <= 2 && user.getUserBooks().size() < 3) {
			Book book = bookRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Book with GUID: " + id + " does not exist."));

			book.setStatus(bookToTake.getStatus().TAKEN);

			Book takenBook = bookRepository.save(book);

			user.getUserBooks().add(takenBook);

			return ResponseEntity.ok(takenBook);
		}
		return null;
	}

//	public List<Book> filterByAuthor(String author) {
//
//		return bookRepository.filterByAuthor(author);
//	}
//
//	public List<Book> filterByCategory(String category) {
//
//		return bookRepository.filterByCategory(category);
//	}
//
//	public List<Book> filterByLanguage(String language) {
//
//		return bookRepository.filterByLanguage(language);
//	}
//
//	public List<Book> filterByISBN(String isbn) {
//
//		return bookRepository.filterByISBN(isbn);
//	}
//
//	public List<Book> filterByName(String name) {
//
//		return bookRepository.filterByName(name);
//	}
//
//	public List<Book> filterByStatus(BookStatus status) {
//
//		return bookRepository.filterByStatus(status);
//	}
}
