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

import co.edu.unal.sam.physicalactivity.model.domain.NewReport;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.NewReportRepository;

@RestController
public class NewReportController {

	@Inject
	private NewReportRepository newReportRepository;

	@RequestMapping(value = "/admin/newReports", method = RequestMethod.POST)
	public ResponseEntity<Void> createNewReport(
			@Valid @RequestBody NewReport newReport) {
		newReport = this.newReportRepository.save(newReport);
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newNewReportUri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newReport.getId()).toUri();
		responseHeaders.setLocation(newNewReportUri);

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/newReports/{newReportId}", method = RequestMethod.GET)
	public ResponseEntity<?> getNewReport(@PathVariable Long newReportId) {
		this.verifyNewReport(newReportId);
		NewReport p = this.newReportRepository.findOne(newReportId);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/newReports", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NewReport>> getAllnewReports() {
		Iterable<NewReport> allnewReports = this.newReportRepository.findAll();
		return new ResponseEntity<>(allnewReports, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/newReports/{newReportId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateNewReport(
			@RequestBody NewReport newReport, @PathVariable Long newReportId) {
		this.verifyNewReport(newReportId);
		this.newReportRepository.save(newReport);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/newReports/{newReportId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteNewReport(@PathVariable Long newReportId) {
		this.verifyNewReport(newReportId);
		this.newReportRepository.delete(newReportId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	protected void verifyNewReport(Long newReportId)
			throws ResourceNotFoundException {
		NewReport newReport = this.newReportRepository.findOne(newReportId);
		if (newReport == null) {
			throw new ResourceNotFoundException("NewReport with id "
					+ newReportId + " not found");
		}
	}

}
