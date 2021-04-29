package lt.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import lt.library.command.BookCommand;
import lt.library.model.Book;
import lt.library.model.BookStatus;
import lt.library.repository.BookRepository;
import lt.library.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LibraryApplicationTests {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@Test
	public void getAllBooksTest() {
		when(bookRepository.findAll()).thenReturn(Stream
				.of(new Book(1L, "name", "author", "category", "language", 1999, "isbn", BookStatus.TAKEN),
						new Book(2L, "name1", "author1", "category1", "language1", 1999, "isbn1", BookStatus.TAKEN))
				.collect(Collectors.toList()));
		assertEquals(2, bookService.getAllBooks().size());
	}

	@Test
	public void addABookTest() {
		BookCommand book = new BookCommand();
		book.setName("name");
		book.setAuthor("author");
		book.setCategory("category");
		book.setLanguage("language");
		book.setPublicationDate(1999);
		book.setIsbn("isbn");
		book.setStatus(BookStatus.TAKEN);
		if (book != null) {
			assertNotNull("New Book is not null", book);

		}

	}

	@Test
	public void getBookByGUIDTest() {

		Book book = new Book(1L, "name", "author", "category", "language", 1999, "isbn", BookStatus.TAKEN);
		when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

	}

}
