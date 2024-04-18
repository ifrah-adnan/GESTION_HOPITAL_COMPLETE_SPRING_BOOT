package ma.adnan.gesion_patient;

import ma.adnan.gesion_patient.entite.Patient;
import ma.adnan.gesion_patient.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class GesionPatientApplication {


    public static void main(String[] args) {
        SpringApplication.run(GesionPatientApplication.class, args);


    }
//    @Bean
    CommandLineRunner commandLineRunner(PatientRepo patientRepository){
        return args -> {
            Patient p1=new Patient(null,"adnan",new Date(2001-11-24),true,20);
            Patient p2=new Patient(null,"ali",new Date(2000-10-3),false,34);
            Patient p3=new Patient(null,"othman",new Date(2002-1-4),false,35);
            Patient p4=new Patient(null,"ahmed",new Date(2005-3-4),true,93);

            List<Patient> patients= Arrays.asList(p1,p2,p3,p4);
            patientRepository.saveAll(patients);
        };

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


