package lt.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.library.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
