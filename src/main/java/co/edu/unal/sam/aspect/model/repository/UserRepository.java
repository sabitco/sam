package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.aspect.model.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
