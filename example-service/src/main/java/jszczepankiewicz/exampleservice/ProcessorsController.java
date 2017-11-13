package jszczepankiewicz.exampleservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jszczepankiewicz
 * @since 2017-11-11
 */
@RestController
public class ProcessorsController {

  @RequestMapping("/best")
  public String greeting(@RequestParam(value = "name", defaultValue = "Ryzen") String name) {
    return "Best processor is " + name + ".";
  }
}
