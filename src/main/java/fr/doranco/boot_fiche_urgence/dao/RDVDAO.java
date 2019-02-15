package fr.doranco.boot_fiche_urgence.dao;

import fr.doranco.boot_fiche_urgence.model.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDVDAO extends JpaRepository<RDV, Long> {
}
