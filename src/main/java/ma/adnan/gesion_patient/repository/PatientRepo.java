package ma.adnan.gesion_patient.repository;

import ma.adnan.gesion_patient.entite.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
public interface PatientRepo extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String keyword , Pageable pageable);


}
