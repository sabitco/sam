package co.edu.unal.sam.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
