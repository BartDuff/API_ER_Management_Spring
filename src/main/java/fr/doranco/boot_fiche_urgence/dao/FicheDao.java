package fr.doranco.boot_fiche_urgence.dao;

import fr.doranco.boot_fiche_urgence.model.Fiche;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FicheDao extends JpaRepository<Fiche, Long> {
        Page<Fiche> findByPatientId(long patientId, Pageable pageable);
        Optional<Fiche> findByIdAndPatientId(long id, long patientId);
}
