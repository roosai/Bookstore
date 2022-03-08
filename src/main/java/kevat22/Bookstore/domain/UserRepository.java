package kevat22.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import kevat22.Bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}
