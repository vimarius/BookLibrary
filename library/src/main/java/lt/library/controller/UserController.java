package lt.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.library.model.User;
import lt.library.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users/{id}")
	@ApiOperation(value = "Get a user by Id", notes = "Returns a user by Id.")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}
}
