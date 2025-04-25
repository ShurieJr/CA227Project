package just.CA227Project;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String getHome(Model model){
        model.addAttribute("id",
                "id no: C112160");
        return "index";   //view name // page name
    }
    //responseEntity
    @GetMapping("/ok")
    public ResponseEntity<String> getResponse(){
        HttpHeaders myheaders = new HttpHeaders();
        myheaders.add("Error Header" , "INTERNAL SERVER ERROR HEADER");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR
        ).headers(myheaders).body("Internal server error!");
    }
}
