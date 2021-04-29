package lt.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> filterByAuthor(String author);

}
