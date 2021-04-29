package lt.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
