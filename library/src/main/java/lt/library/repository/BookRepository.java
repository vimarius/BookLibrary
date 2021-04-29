package lt.library.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.library.model.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
