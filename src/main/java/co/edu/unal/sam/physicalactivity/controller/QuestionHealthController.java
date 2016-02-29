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

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.domain.QuestionHealth;
import co.edu.unal.sam.physicalactivity.model.repository.QuestionHealthRepository;

@RestController
public class QuestionHealthController {

	@Inject
	private QuestionHealthRepository questionHealthRepository;

	@RequestMapping(value = "/admin/questionHealths", method = RequestMethod.POST)
	public ResponseEntity<Void> createQuestionHealth(
			@Valid @RequestBody QuestionHealth questionHealth) {
		questionHealth = this.questionHealthRepository.save(questionHealth);
		// Set the location header for the newly created resource
		final HttpHeaders responseHeaders = new HttpHeaders();
		final URI newQuestionHealthUri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(questionHealth.getId()).toUri();
		responseHeaders.setLocation(newQuestionHealthUri);

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/questionHealths/{questionHealthId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteQuestionHealth(
			@PathVariable final Long questionHealthId) {
		this.verifyQuestionHealth(questionHealthId);
		this.questionHealthRepository.delete(questionHealthId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/questionHealths", method = RequestMethod.GET)
	public ResponseEntity<Iterable<QuestionHealth>> getAllquestionHealths() {
		final Iterable<QuestionHealth> allquestionHealths = this.questionHealthRepository
				.findAll();
		return new ResponseEntity<>(allquestionHealths, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/questionHealths/{questionHealthId}", method = RequestMethod.GET)
	public ResponseEntity<?> getQuestionHealth(
			@PathVariable final Long questionHealthId) {
		this.verifyQuestionHealth(questionHealthId);
		final QuestionHealth p = this.questionHealthRepository
				.findOne(questionHealthId);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/questionHealths/{questionHealthId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateQuestionHealth(
			@RequestBody final QuestionHealth questionHealth,
			@PathVariable final Long questionHealthId) {
		this.verifyQuestionHealth(questionHealthId);
		this.questionHealthRepository.save(questionHealth);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	protected void verifyQuestionHealth(final Long questionHealthId)
			throws ResourceNotFoundException {
		final QuestionHealth questionHealth = this.questionHealthRepository
				.findOne(questionHealthId);
		if (questionHealth == null) {
			throw new ResourceNotFoundException("QuestionHealth with id "
					+ questionHealthId + " not found");
		}
	}

}
