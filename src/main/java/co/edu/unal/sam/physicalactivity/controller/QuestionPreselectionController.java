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

import co.edu.unal.sam.physicalactivity.model.domain.QuestionPreselection;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.QuestionPreselectionRepository;

@RestController
public class QuestionPreselectionController {

    @Inject
    private QuestionPreselectionRepository questionPreselectionRepository;

    @RequestMapping(value = "/admin/questionPreselections", method = RequestMethod.POST)
    public ResponseEntity<Void> createQuestionPreselection(@Valid @RequestBody QuestionPreselection questionPreselection) {
        questionPreselection = this.questionPreselectionRepository.save(questionPreselection);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newQuestionPreselectionUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(questionPreselection.getId()).toUri();
        responseHeaders.setLocation(newQuestionPreselectionUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/questionPreselections/{questionPreselectionId}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionPreselection(@PathVariable Long questionPreselectionId) {
        this.verifyQuestionPreselection(questionPreselectionId);
        QuestionPreselection p = this.questionPreselectionRepository.findOne(questionPreselectionId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/questionPreselections", method = RequestMethod.GET)
    public ResponseEntity<Iterable<QuestionPreselection>> getAllquestionPreselections() {
        Iterable<QuestionPreselection> allquestionPreselections = this.questionPreselectionRepository.findAll();
        return new ResponseEntity<>(allquestionPreselections, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/questionPreselections/{questionPreselectionId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateQuestionPreselection(@RequestBody QuestionPreselection questionPreselection, @PathVariable Long questionPreselectionId) {
        this.verifyQuestionPreselection(questionPreselectionId);
        this.questionPreselectionRepository.save(questionPreselection);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/questionPreselections/{questionPreselectionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteQuestionPreselection(@PathVariable Long questionPreselectionId) {
        this.verifyQuestionPreselection(questionPreselectionId);
        this.questionPreselectionRepository.delete(questionPreselectionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyQuestionPreselection(Long questionPreselectionId) throws ResourceNotFoundException {
        QuestionPreselection questionPreselection = this.questionPreselectionRepository.findOne(questionPreselectionId);
        if (questionPreselection == null) {
            throw new ResourceNotFoundException("QuestionPreselection with id " + questionPreselectionId + " not found");
        }
    }

}
