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
	@ApiOperation(value = "Get a book", notes = "Returns a book by GUID.")
	public ResponseEntity<Book> getBookByGUID(@PathVariable("id") Long id) {
		return bookService.getBookByGUID(id);
	}

}
