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
import co.edu.unal.sam.physicalactivity.model.domain.City;
import co.edu.unal.sam.physicalactivity.model.domain.State;
import co.edu.unal.sam.physicalactivity.model.service.CityService;
import co.edu.unal.sam.physicalactivity.model.service.StateService;

@RestController
public class StateController {

    @Inject
    private StateService stateService;

    @Inject
    private CityService cityService;

    @RequestMapping(value = "/state", method = RequestMethod.GET)
    public ResponseEntity<Iterable<State>> getStates(
            @RequestParam(name = "state", required = false) final StateEnum state) {
        final Iterable<State> all = this.stateService.getStates(state);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/states/cities/{campusId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<City>> getCities(@PathVariable final Long stateId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        final State campus = this.stateService.verify(stateId);
        final Iterable<City> all = this.cityService.getCities(campus, state);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
