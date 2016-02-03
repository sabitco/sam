package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.aspect.model.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
