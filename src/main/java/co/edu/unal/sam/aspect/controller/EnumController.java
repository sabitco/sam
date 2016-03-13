package co.edu.unal.sam.aspect.controller ;

import org.springframework.http.HttpStatus ;
import org.springframework.http.ResponseEntity ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RestController ;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum ;

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
  public ResponseEntity<StateEnum []> getAllStatesEnumByAvailable() {
	final StateEnum [] allstates = StateEnum.values() ;
	return new ResponseEntity<>(allstates, HttpStatus.OK) ;
  }
}
