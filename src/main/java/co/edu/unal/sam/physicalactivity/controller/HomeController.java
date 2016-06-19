package co.edu.unal.sam.physicalactivity.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.dto.TipDto;
import co.edu.unal.sam.physicalactivity.model.service.HomeService;

@RestController
public class HomeController {

    @Inject
    private HomeService service;

    @RequestMapping(value = "/home/advantages", method = RequestMethod.GET)
    public ResponseEntity<Iterable<TipDto>> getAdvantages(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<TipDto> tips = this.service.getAdvantages(state);
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/alerts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<TipDto>> getAlerts(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<TipDto> tips = this.service.getAlerts(state);
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/myths", method = RequestMethod.GET)
    public ResponseEntity<Iterable<TipDto>> getMyths(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<TipDto> tips = this.service.getMyths(state);
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/tips", method = RequestMethod.GET)
    public ResponseEntity<Iterable<TipDto>> getTips(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<TipDto> tips = this.service.getTips(state);
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

}
