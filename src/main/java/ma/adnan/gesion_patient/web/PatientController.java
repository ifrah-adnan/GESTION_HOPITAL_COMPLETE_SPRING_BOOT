package ma.adnan.gesion_patient.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Generated;
import ma.adnan.gesion_patient.entite.Patient;
import ma.adnan.gesion_patient.repository.PatientRepo;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepo patientRepo;

    @GetMapping("/user/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "4") int size, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patientList = patientRepo.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("pages", new int[patientList.getTotalPages()]);
        model.addAttribute("ListPatient", patientList.getContent());
        model.addAttribute("currentAttribute", page);
        model.addAttribute("kw", keyword);
        return "patients";

    }
    @GetMapping("/admin/delete")

    public String delete(@RequestParam(name = "id") Long id ,@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "keyword", defaultValue = "") String keyword){
        patientRepo.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;

}
@GetMapping("/admin/formPatients")
public String formPatients(Model model){
        model.addAttribute("patient",new Patient());

        return "formPatients";


}
@PostMapping("/admin/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "keyword", defaultValue = "") String keyword){
       if(bindingResult.hasErrors()){
           return "formPatients";
       }
        patientRepo.save(patient);

    return "redirect:/user/index?page="+page+"&keyword="+keyword;

    }
    @GetMapping("/admin/editPatient")
    public String editPatient(Model model,Long id,@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "keyword", defaultValue = "") String keyword){
        Patient patient=patientRepo.findById(id).orElse(null);
        if(patient==null)throw new RuntimeException("patient est introuvable");
        model.addAttribute("patient",patient);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "editPatient";
    }
    @GetMapping("/")
    public String Home(){
        return "redirect:/user/index";
    }


}

