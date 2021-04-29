package lt.library;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
}
