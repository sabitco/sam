package co.edu.unal.sam.aspect.controller ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.http.HttpStatus ;
import org.springframework.http.ResponseEntity ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RestController ;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum ;
import co.edu.unal.sam.aspect.model.enumerator.TypePageEnum ;

/**
 * The Class EnumController.
 */
@RestController
public class EnumController {

  /**
   * Gets the all states enum by available.
   *
   * @return the all states enum by available
   */
  @RequestMapping(value = "/enum/states", method = RequestMethod.GET)
  public ResponseEntity<List<StateEnum>> getAllStatesEnumByAvailable() {
	final List<StateEnum> allstates = new ArrayList<StateEnum>() ;
	for (final StateEnum state : StateEnum.values()) {
	  if (Boolean.TRUE.equals(state.getAvailable())) {
		allstates.add(state) ;
	  }
	}
	return new ResponseEntity<>(allstates, HttpStatus.OK) ;
  }

  /**
   * Gets the all type page by available.
   *
   * @return the all type page by available
   */
  @RequestMapping(value = "/enum/typepage", method = RequestMethod.GET)
  public ResponseEntity<List<TypePageEnum>> getAllTypePageByAvailable() {
	final List<TypePageEnum> alltypePages = new ArrayList<TypePageEnum>() ;
	for (final TypePageEnum typePage : TypePageEnum.values()) {
	  if (Boolean.TRUE.equals(typePage.getAvailable())) {
		alltypePages.add(typePage) ;
	  }
	}
	return new ResponseEntity<>(alltypePages, HttpStatus.OK) ;
  }
}
