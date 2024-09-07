package controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HlloCont {
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String Hello() {
	        return "Hello world!";
	    }

}
