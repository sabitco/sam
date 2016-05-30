package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByIdentityDocument(String username);

    User findByUsername(String username);

    @Modifying
    @Query("update User u set u.weight = :weight, height = :height, bmi = :bmi where u.id = :id")
    int setBmiInfoById(@Param("weight") Float weight, @Param("height") Float height,
            @Param("bmi") Float bmi, @Param("id") Long id);

}
