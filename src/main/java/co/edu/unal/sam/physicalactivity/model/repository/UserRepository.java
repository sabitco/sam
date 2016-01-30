package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
