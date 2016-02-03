package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.aspect.model.domain.MailTemplate;

public interface MailTemplateRepository extends
		CrudRepository<MailTemplate, Long> {

}
