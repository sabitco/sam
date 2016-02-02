package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
