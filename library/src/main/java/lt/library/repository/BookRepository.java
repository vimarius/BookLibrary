package lt.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
