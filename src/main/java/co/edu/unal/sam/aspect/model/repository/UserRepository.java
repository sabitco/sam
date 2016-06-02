package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.unal.sam.aspect.model.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByIdentityDocument(String username);

    User findByUsername(String username);

}
