package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByIdentityDocument(String username);

    User findByUsername(String username);

    @Query(name = "User.findUserDtoByUsername")
    UserDto findUserDtoByUsername(@Param("username") String username);

}
