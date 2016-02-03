package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.aspect.model.domain.Page;

public interface PageRepository extends CrudRepository<Page, Long> {

}
