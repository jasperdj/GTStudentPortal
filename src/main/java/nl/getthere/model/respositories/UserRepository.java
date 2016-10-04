package nl.getthere.model.respositories;

import nl.getthere.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail(String username);
}
