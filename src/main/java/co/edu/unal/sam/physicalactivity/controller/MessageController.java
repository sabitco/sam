package co.edu.unal.sam.physicalactivity.controller;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.unal.sam.physicalactivity.model.domain.Message;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.MessageRepository;

@RestController
public class MessageController {

    @Inject
    private MessageRepository messageRepository;

    @RequestMapping(value = "/admin/messages", method = RequestMethod.POST)
    public ResponseEntity<Void> createMessage(@Valid @RequestBody Message message) {
        message = this.messageRepository.save(message);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newMessageUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(message.getId()).toUri();
        responseHeaders.setLocation(newMessageUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/messages/{messageId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMessage(@PathVariable Long messageId) {
        this.verifyMessage(messageId);
        Message p = this.messageRepository.findOne(messageId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/messages", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Message>> getAllmessages() {
        Iterable<Message> allmessages = this.messageRepository.findAll();
        return new ResponseEntity<>(allmessages, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/messages/{messageId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateMessage(@RequestBody Message message, @PathVariable Long messageId) {
        this.verifyMessage(messageId);
        this.messageRepository.save(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/messages/{messageId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMessage(@PathVariable Long messageId) {
        this.verifyMessage(messageId);
        this.messageRepository.delete(messageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyMessage(Long messageId) throws ResourceNotFoundException {
        Message message = this.messageRepository.findOne(messageId);
        if (message == null) {
            throw new ResourceNotFoundException("Message with id " + messageId + " not found");
        }
    }

}
