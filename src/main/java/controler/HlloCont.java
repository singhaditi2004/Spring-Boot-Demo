package controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HlloCont {
	 @GetMapping("/")
	    public String Hello() {
	        return "Hello world!  uyyb";
	    }

}
