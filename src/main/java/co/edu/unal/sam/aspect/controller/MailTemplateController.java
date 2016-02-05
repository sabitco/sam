package co.edu.unal.sam.aspect.controller;

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

import co.edu.unal.sam.aspect.model.domain.MailTemplate;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.repository.MailTemplateRepository;

@RestController
public class MailTemplateController {

    @Inject
    private MailTemplateRepository mailTemplateRepository;

    @RequestMapping(value = "/admin/mailTemplates", method = RequestMethod.POST)
    public ResponseEntity<Void> createMailTemplate(@Valid @RequestBody MailTemplate mailTemplate) {
        mailTemplate = this.mailTemplateRepository.save(mailTemplate);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newMailTemplateUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(mailTemplate.getId()).toUri();
        responseHeaders.setLocation(newMailTemplateUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/mailTemplates/{mailTemplateId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMailTemplate(@PathVariable Long mailTemplateId) {
        this.verifyMailTemplate(mailTemplateId);
        MailTemplate p = this.mailTemplateRepository.findOne(mailTemplateId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/mailTemplates", method = RequestMethod.GET)
    public ResponseEntity<Iterable<MailTemplate>> getAllmailTemplates() {
        Iterable<MailTemplate> allmailTemplates = this.mailTemplateRepository.findAll();
        return new ResponseEntity<>(allmailTemplates, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/mailTemplates/{mailTemplateId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateMailTemplate(@RequestBody MailTemplate mailTemplate, @PathVariable Long mailTemplateId) {
        this.verifyMailTemplate(mailTemplateId);
        this.mailTemplateRepository.save(mailTemplate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/mailTemplates/{mailTemplateId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMailTemplate(@PathVariable Long mailTemplateId) {
        this.verifyMailTemplate(mailTemplateId);
        this.mailTemplateRepository.delete(mailTemplateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyMailTemplate(Long mailTemplateId) throws ResourceNotFoundException {
        MailTemplate mailTemplate = this.mailTemplateRepository.findOne(mailTemplateId);
        if (mailTemplate == null) {
            throw new ResourceNotFoundException("MailTemplate with id " + mailTemplateId + " not found");
        }
    }

}
