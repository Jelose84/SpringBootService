package guijo.la.chupa.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import guijo.la.chupa.spring.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
