package co.edu.unal.sam.aspect.model.repository ;

import org.springframework.data.repository.PagingAndSortingRepository ;

import co.edu.unal.sam.aspect.model.domain.Page ;

public interface PageRepository extends PagingAndSortingRepository<Page, Long> {
    
    Page findByBase(String base);
  
}
