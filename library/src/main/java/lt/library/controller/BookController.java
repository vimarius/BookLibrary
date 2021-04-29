package lt.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.library.command.BookCommand;
import lt.library.model.Book;
import lt.library.model.BookStatus;
import lt.library.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books")
	@ApiOperation(value = "Get all books", notes = "Returns all books.")
	public List<Book> getAllProjects() {
		return bookService.getAllBooks();
	}

	@PostMapping("/books")
	@ApiOperation(value = "Add a book", notes = "Adds a book.")
	public void addABook(@RequestBody BookCommand book) {
		bookService.addABook(book);
	}

	@GetMapping("/books/{id}")
	@ApiOperation(value = "Get a book by GUID", notes = "Returns a book by GUID.")
	public ResponseEntity<Book> getBookByGUID(@PathVariable("id") Long id) {
		return bookService.getBookByGUID(id);
	}

	@GetMapping("/books/{author}")
	@ApiOperation(value = "Get a list of books by author", notes = "Filters books by author.")
	public List<Book> filterByAuthor(@PathVariable("author") String author) {
		return bookService.filterByAuthor(author);
	}

	@GetMapping("/books/{category}")
	@ApiOperation(value = "Get a list of books by category", notes = "Filters books by category.")
	public List<Book> filterByCategory(@PathVariable("category") String category) {
		return bookService.filterByCategory(category);
	}

	@GetMapping("/books/{language}")
	@ApiOperation(value = "Get a list of books by language", notes = "Filters books by language.")
	public List<Book> filterByLanguage(@PathVariable("language") String language) {
		return bookService.filterByLanguage(language);
	}

	@GetMapping("/books/{isbn}")
	@ApiOperation(value = "Get a list of books by ISBN", notes = "Filters books by ISBN.")
	public List<Book> filterByISBN(@PathVariable("isbn") String isbn) {
		return bookService.filterByISBN(isbn);
	}

	@GetMapping("/books/{name}")
	@ApiOperation(value = "Get a list of books by name", notes = "Filters books by name.")
	public List<Book> filterByName(@PathVariable("name") String name) {
		return bookService.filterByName(name);
	}

	@GetMapping("/books/{status}")
	@ApiOperation(value = "Get a list of books by status", notes = "Filters books by status.")
	public List<Book> filterByStatus(@PathVariable("status") BookStatus status) {
		return bookService.filterByStatus(status);
	}

}
