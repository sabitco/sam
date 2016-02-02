package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.ProductSupport;

public interface ProductSopportRepository extends
		CrudRepository<ProductSupport, Long> {

}