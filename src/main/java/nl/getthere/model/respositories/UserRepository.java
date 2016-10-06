package nl.getthere.model.respositories;

import nl.getthere.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail(String username);
}
