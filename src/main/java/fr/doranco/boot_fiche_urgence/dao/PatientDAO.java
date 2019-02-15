package fr.doranco.boot_fiche_urgence.dao;

import fr.doranco.boot_fiche_urgence.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Long> {
}
