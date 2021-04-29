package lt.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//	List<Book> filterByAuthor(String author);
//
//	List<Book> filterByCategory(String category);
//
//	List<Book> filterByLanguage(String language);
//
//	List<Book> filterByISBN(String isbn);
//
//	List<Book> filterByName(String name);
//
//	List<Book> filterByStatus(BookStatus status);

}
