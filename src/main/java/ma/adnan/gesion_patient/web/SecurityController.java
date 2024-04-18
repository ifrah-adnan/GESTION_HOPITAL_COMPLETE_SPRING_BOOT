package ma.adnan.gesion_patient.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Controller
public class SecurityController {
    @GetMapping("/notAuthorized")
    public String NotAuthorized(){
        return "NotAuthorized";
    }
        @GetMapping("/login")
        public String login(){
            return "login";
        }
}
