package co.edu.unal.sam.physicalactivity.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Advantage;
import co.edu.unal.sam.physicalactivity.model.domain.Alert;
import co.edu.unal.sam.physicalactivity.model.domain.Event;
import co.edu.unal.sam.physicalactivity.model.domain.Myth;
import co.edu.unal.sam.physicalactivity.model.domain.Tip;
import co.edu.unal.sam.physicalactivity.model.dto.AdvantageDto;
import co.edu.unal.sam.physicalactivity.model.dto.AlertDto;
import co.edu.unal.sam.physicalactivity.model.dto.EventDto;
import co.edu.unal.sam.physicalactivity.model.dto.MythDto;
import co.edu.unal.sam.physicalactivity.model.dto.TipDto;
import co.edu.unal.sam.physicalactivity.model.service.HomeService;

@RestController
public class HomeController {

    @Inject
    private HomeService service;

    @RequestMapping(value = "/home/advantages/{avantageId}", method = RequestMethod.GET)
    public ResponseEntity<Advantage> getAdvantage(@PathVariable Long avantageId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        return new ResponseEntity<>(this.service.getAdvantage(avantageId), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/advantages", method = RequestMethod.GET)
    public ResponseEntity<Iterable<AdvantageDto>> getAdvantages(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<AdvantageDto> advantages = this.service.getAdvantages(state);
        return new ResponseEntity<>(advantages, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/alerts/{alertId}", method = RequestMethod.GET)
    public ResponseEntity<Alert> getAlert(@PathVariable Long alertId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        return new ResponseEntity<>(this.service.getAlert(alertId), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/alerts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<AlertDto>> getAlerts(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<AlertDto> alerts = this.service.getAlerts(state);
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/events/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEvent(@PathVariable Long eventId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        return new ResponseEntity<>(this.service.getEvent(eventId), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/events", method = RequestMethod.GET)
    public ResponseEntity<Iterable<EventDto>> getEvents(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<EventDto> events = this.service.getEvents(state);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/myths/{mythId}", method = RequestMethod.GET)
    public ResponseEntity<Myth> getMyth(@PathVariable Long mythId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        return new ResponseEntity<>(this.service.getMyth(mythId), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/myths", method = RequestMethod.GET)
    public ResponseEntity<Iterable<MythDto>> getMyths(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<MythDto> myths = this.service.getMyths(state);
        return new ResponseEntity<>(myths, HttpStatus.OK);
    }

    @RequestMapping(value = "/home/tips/{tipId}", method = RequestMethod.GET)
    public ResponseEntity<Tip> getTip(@PathVariable Long tipId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        return new ResponseEntity<>(this.service.getTip(tipId), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/tips", method = RequestMethod.GET)
    public ResponseEntity<Iterable<TipDto>> getTips(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        Iterable<TipDto> tips = this.service.getTips(state);
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

}
