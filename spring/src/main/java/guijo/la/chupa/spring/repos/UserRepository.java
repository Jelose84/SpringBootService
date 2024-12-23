package guijo.la.chupa.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guijo.la.chupa.spring.model.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameAndPasswordStartsWith(String name, String password);
}
